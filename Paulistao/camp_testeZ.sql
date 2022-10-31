CREATE DATABASE camp_testeZ
go
USE camp_testeZ
go
CREATE TABLE times
(
CodigoTime	INT				NOT NULL,
NomeTime	VARCHAR(50)		NOT NULL,
Cidade		VARCHAR(50)		NOT NULL,
Estadio		VARCHAR(50)		NOT NULL
PRIMARY KEY(CodigoTime)
)
go
CREATE TABLE grupos
(
Grupo		CHAR(1)		NOT NULL 	CHECK(Grupo = 'A' OR Grupo = 'B' OR Grupo = 'C' OR Grupo = 'D'), 
CodigoTime	INT			NOT NULL,
PRIMARY KEY(Grupo, CodigoTime),
FOREIGN KEY(CodigoTime) REFERENCES times(CodigoTime)
)
go
CREATE TABLE jogos
(
CodigoTimeA		INT		NOT NULL,
CodigoTimeB		INT		NOT NULL,
GolsTimeA		INT		NULL,
GolsTimeB		INT		NULL,
Data			DATE	NULL
PRIMARY KEY(CodigoTimeA, CodigoTimeB)
)
go
INSERT INTO times VALUES
(1, 'Corinthians', 'São Paulo', 'Neo Química Arena'),
(2, 'Palmeiras', 'São Paulo', 'Allanz Parque'),
(3, 'Santos', 'Santos', 'Vila Belmiro'),
(4, 'São Paulo', 'São Paulo', 'Morumbi'),
(5, 'Botafogo-SP', 'Ribeirão Preto', 'Santa Cruz'),
(6, 'Ferroviária', 'Araraquara', 'Fonte Luminosa'),
(7, 'Guarani', 'Campinas', 'Brinco de Ouro'),
(8, 'Inter de Limeira', 'Limeira', 'Limeirão'),
(9, 'Ituano', 'Itu', 'Novelli Júnior'),
(10, 'Mirassol', 'Mirassol', 'José Maria de Campos Maia'),
(11, 'Novorizontino', 'Novo Horizonte', 'Jorge Ismael de Biasi'),
(12, 'Ponte Preta', 'Campinas', 'Moisés Lucarelli'),
(13, 'Red Bull Bragantino', 'Bragança Paulista', 'Nabi Abi Chedid'),
(14, 'Santo André', 'Santo André', 'Bruno José Daniel'),
(15, 'São Bento', 'Sorocaba', 'Walter Ribeiro'),
(16, 'São Caetano', 'São Caetano do Sul', 'Anacletto Campanella')

CREATE PROCEDURE p_geraGrupos_1 (@grupo1 CHAR(1), @grupo2 CHAR(1), 
								 @grupo3 CHAR(1), @grupo4 CHAR(1))
AS														
DECLARE @grupo char(1),			
		@time INT,
		@rand1 INT

SET @time = 5
	WHILE (@time <= 10) 
	BEGIN
		IF(@time % 2 = 0)
		BEGIN
			SET @grupo = @grupo1
		END
		ELSE
		BEGIN
			SET @grupo = @grupo2
		END
		INSERT INTO grupos VALUES
		(@grupo, @time)
		SET @time = @time + 1
	END

	WHILE (@time <= 16) 
	BEGIN
		IF(@time % 2 = 0)
		BEGIN
			SET @grupo = @grupo3
		END
		ELSE
		BEGIN
			SET @grupo = @grupo4
		END
		INSERT INTO grupos VALUES
		(@grupo, @time)
		SET @time = @time + 1
	END


---------------------------------------------------------------------------------------------------
CREATE PROCEDURE p_geraGrupo
AS
DECLARE	@grupo char(1),
		@time INT,
		@rand INT
SET @rand = (RAND() * 2) + 1 
SET @time = 0
	WHILE (@time < 4)
		BEGIN
			IF (@time = 0)
			BEGIN
				SET @grupo = 'A'
			END
			ELSE
				IF (@time = 1)
				BEGIN
					SET @grupo = 'B'
				END
				ELSE
					IF (@time = 2)
					BEGIN
						SET @grupo = 'C'
					END
					ELSE
						IF (@time = 3)
						BEGIN
							SET @grupo = 'D'
						END
			SET @time = @time + 1
			INSERT INTO grupos VALUES
			(@grupo, @time)
		END
			EXEC p_geraGrupos_1 @grupo1 = 'C', @grupo2 = 'D', @grupo3 = 'A', @grupo4 = 'B'			


------------------------------------------------------------------------------------------------------
/*************************************************** PROCEDURE PARA DATAS ******************/
CREATE PROCEDURE pd_data(@data DATE)
AS
	DECLARE @aux DATE
	--Se for domingo, próximo dia de jogo é daqui a 3 dias
	IF(DATEPART(WEEKDAY, @data) = 1) 
	BEGIN
		SET @aux = DATEADD(DAY, 3, @data)
		SET @aux = CONVERT(VARCHAR(10), @aux)
		SET @data = @aux
		PRINT @data  
	END
	--Se for quarta-feira, próximo dia de jogo é daqui a 4 dias
	ELSE
	BEGIN
		SET @aux = DATEADD(DAY, 4, @data)
		SET @aux = CONVERT(VARCHAR(10), @aux)
		SET @data = @aux
		PRINT @data 
	END

EXEC pd_data @data = '09/02/2022'


/***************************************** PROCEDURE PARA CRIAR JOGOS ***********************/
CREATE PROCEDURE pro_geraJogosT1 (@cont INT, @time1 INT, @parm1 INT, @parm2 INT, @parm3 INT, @data DATE)
AS
	DECLARE @timeA INT,
			@timeB INT
	WHILE @cont <= 16 
	BEGIN
		SET @timeA = @time1
		IF (@cont = @parm1 or @cont = @parm2 or @cont = @parm3)
		BEGIN
			SET @cont = @cont + 1
		END
		ELSE
		BEGIN
			SET @timeB = @cont
			EXEC pd_data @data
			INSERT INTO jogos VALUES
			(@timeA, @timeB, NULL, NULL, @data)
			SET @cont = @cont + 1
		END
	END

/**************************************** PROCEDURE PARA AUXILIAR A CRIAR JOGOS ***********************/
CREATE PROCEDURE pro_geraJogosT2 (@cont INT, @time1 INT, @parm1 INT, @parm2 INT, @data DATE)
AS
	DECLARE @timeA INT,
			@timeB INT
	WHILE @cont <= 16 
	BEGIN
		SET @timeA = @time1
		IF (@cont = @parm1 or @cont = @parm2)
		BEGIN
			SET @cont = @cont + 1
		END
		ELSE
		BEGIN
			SET @timeB = @cont
			EXEC pd_data @data
			INSERT INTO jogos VALUES
			(@timeA, @timeB, NULL, NULL, @data)
			SET @cont = @cont + 1
		END
	END

/*************************************************** PROCEDURE PARA AUXILIAR A CRIAR JOGOS ******************/
CREATE PROCEDURE pro_geraJogosT3 (@cont INT, @time1 INT, @parm1 INT, @data DATE)
AS
	DECLARE @timeA INT,
			@timeB INT
	WHILE @cont <= 16 
	BEGIN
		SET @timeA = @time1
		IF (@cont = @parm1)
		BEGIN
			SET @cont = @cont + 1
		END
		ELSE
		BEGIN
			SET @timeB = @cont
			EXEC pd_data @data
			INSERT INTO jogos VALUES
			(@timeA, @timeB, NULL, NULL, @data)
			SET @cont = @cont + 1
		END
	END

/*************************************************** PROCEDURE PARA AUXILIAR A CRIAR JOGOS ******************/
CREATE PROCEDURE pro_geraJogosT4 (@cont INT, @time1 INT, @data DATE)
AS
	DECLARE @timeA INT,
			@timeB INT
	WHILE @cont <= 16 
	BEGIN
		SET @timeA = @time1
		BEGIN
			SET @timeB = @cont
			EXEC pd_data @data
			INSERT INTO jogos VALUES
			(@timeA, @timeB, NULL, NULL, @data)
			SET @cont = @cont + 1
		END
	END

/****************************************************** GERAR PARTIDAS ********************************/
CREATE PROCEDURE pro_partidasT1
AS
	DECLARE @timeA INT,
			@timeB INT,
			@cont INT,
			@cont1 INT,
			@dataUltimo DATE,
			@data DATE
SET @cont1 = 5	
SET @dataUltimo = '23/02/2022'

--CABEÇAS
	INSERT INTO jogos VALUES
	(1,2,NULL,NULL,'06/02/2022'),
	(1,3,NULL,NULL,'09/02/2022'),
	(1,4,NULL,NULL,'13/02/2022'),
	(2,3,NULL,NULL,'13/02/2022'),
	(2,4,NULL,NULL,'09/02/2022'),
	(3,4,NULL,NULL,'06/02/2022')

--RESTO 1
	EXEC pro_geraJogosT1 5 , 1, 12, 14, 16, '13/02/2022'

--RESTO 2
	EXEC pro_geraJogosT1 5 , 2, 11, 13, 15, '13/02/2022'

--RESTO 3
	EXEC pro_geraJogosT1 5 , 3, 6, 8, 10, '13/02/2022'

--RESTO 4
	EXEC pro_geraJogosT1 5 , 4, 5, 7, 9, '13/02/2022'

--RESTO 5
	EXEC pro_geraJogosT2 6, 5, 7, 9, '16/02/2022'

--RESTO 6
	EXEC pro_geraJogosT2 7, 6, 8, 10, '16/02/2022'

--RESTO 7
	EXEC pro_geraJogosT3 8, 7, 9, '16/02/2022'

--RESTO 8
	EXEC pro_geraJogosT3 9, 8, 10, '16/02/2022'

--RESTO 9
	EXEC pro_geraJogosT4 10, 9, '20/02/2022'
	
--RESTO 11
	EXEC pro_geraJogosT4 11, 10, '20/02/2022'

--RESTO 12
	EXEC pro_geraJogosT4 12, 11, '20/02/2022'

--RESTO 13
	EXEC pro_geraJogosT4 13, 12, '20/02/2022'

--VIEW QUE ORGANIZA OS TIMES NA MESMA COLUNA E VAI SER USADA NA fn_placarGrupo
CREATE VIEW v_jogos_disputados
AS
SELECT gp.Grupo, tm.NomeTime, jg.CodigoTimeA as CodigoTime, jg.GolsTimeA as gols
FROM jogos jg, times tm, grupos gp
WHERE jg.CodigoTimeA = tm.CodigoTime
	  AND gp.CodigoTime = tm.CodigoTime
	  AND jg.GolsTimeA IS NOT NULL
UNION ALL
SELECT gp.Grupo, tm.NomeTime, jg.CodigoTimeB  as CodigoTime, jg.GolsTimeB  as gols
FROM jogos jg, times tm, grupos gp
WHERE jg.CodigoTimeB = tm.CodigoTime
	  AND gp.CodigoTime = tm.CodigoTime
	  AND jg.GolsTimeB IS NOT NULL


--FUNCTION QUE MOSTRA O PLACAR POR GRUPO
CREATE FUNCTION fn_placarGrupo(@sigla CHAR(1))
RETURNS @grupo TABLE (
nomeTime VARCHAR(50),
num_jogos_disputados INT,
vitorias INT,
empates INT,
derrotas INT,
gols_marcados INT,
gols_sofridos INT,
saldo_gols INT,
pontos INT
)
AS BEGIN
	DECLARE @nome VARCHAR(100),
			@disputados INT,
			@vitorias INT,
			@empate INT,
			@derrotas INT,
			@golsMarcados INT,
			@golsSofridos INT,
			@saldoGols INT,
			@pontos INT,
			@cont INT,
			@time INT
			
	SET @cont = 0

		WHILE (@cont < 4)
		BEGIN
			SET @time = (SELECT TOP(1) codigoTime from grupos WHERE grupo = @sigla AND
				(codigoTime not in (SELECT TOP(@cont) codigoTime FROM grupos WHERE grupo = @sigla)))

			SET @nome = null
			SET @disputados = 0
			SET @vitorias = 0
			SET @derrotas = 0
			SET @empate = 0
			SET @golsMarcados = 0
			SET @golsSofridos = 0
			SET @saldoGols = 0
			SET @pontos = 0

			SET @nome = (SELECT NomeTime FROM times WHERE codigoTime = @time)
			SET @disputados = (SELECT COUNT(@time) FROM v_jogos_disputados WHERE CodigoTime = @time)
			SET @golsMarcados = (SELECT SUM(gols) FROM v_jogos_disputados WHERE CodigoTime = @time)
			
			DECLARE @timeA smallint
			DECLARE @timeB smallint
			DECLARE @golsTimeA smallint
			DECLARE @golsTimeB smallint
			DECLARE c CURSOR FOR SELECT codigoTimeA, CodigoTimeB, golsTimeA, golsTimeB FROM jogos

			OPEN c
			FETCH NEXT FROM c INTO @timeA, @timeB, @golsTimeA, @golsTimeB

			WHILE @@FETCH_STATUS = 0
			BEGIN
				IF @timeA = @time or @timeB = @time
				BEGIN 
					IF (@golsTimeA IS not NULL) OR  (@golsTimeB IS not NULL)
					BEGIN
						
						IF(@time = @timeA)
						BEGIN
							--time A ganha
							IF(@golsTimeA > @golsTimeB)
							BEGIN	
								SET @vitorias = @vitorias + 1
								SET @golsMarcados = @golsTimeA + @golsMarcados
								SET @golsSofridos = @golsTimeB + @golsSofridos
								SET @saldoGols = @golsMarcados - @golsSofridos
								SET @pontos = @pontos + 3	
							END
							--time A perde
							IF(@golsTimeA < @golsTimeB)
							BEGIN	
								SET @derrotas = @derrotas + 1
								SET @golsMarcados = @golsTimeA + @golsMarcados
								SET @golsSofridos = @golsTimeB + @golsSofridos
								SET @saldoGols = @golsMarcados - @golsSofridos
							END
							--Empate
							IF(@golsTimeA = @golsTimeB)
							BEGIN	
								SET @empate = @empate + 1
								SET @golsMarcados = @golsTimeA + @golsMarcados
								SET @golsSofridos = @golsTimeB + @golsSofridos
								SET @saldoGols = @golsMarcados - @golsSofridos
								SET @pontos = @pontos + 1	
							END	
						END
						ELSE
						BEGIN
							--time B ganha
							IF(@golsTimeA < @golsTimeB)
							BEGIN	
								SET @vitorias = @vitorias + 1
								SET @golsMarcados = @golsTimeB + @golsMarcados
								SET @golsSofridos = @golsTimeA + @golsSofridos
								SET @saldoGols = @golsMarcados - @golsSofridos
								SET @pontos = @pontos + 3	
							END
							--time B perde
							IF(@golsTimeA > @golsTimeB)
							BEGIN	
								SET @derrotas = @derrotas + 1
								SET @golsMarcados = @golsTimeB + @golsMarcados
								SET @golsSofridos = @golsTimeB + @golsSofridos
								SET @saldoGols = @golsMarcados - @golsSofridos
							END
							--Empate
							IF(@golsTimeA = @golsTimeB)
							BEGIN	
								SET @empate = @empate + 1
								SET @golsMarcados = @golsTimeA + @golsMarcados
								SET @golsSofridos = @golsTimeB + @golsSofridos
								SET @saldoGols = @golsMarcados - @golsSofridos
								SET @pontos = @pontos + 1	
							END	
						END
					END
				END
				FETCH NEXT FROM c INTO @timeA, @timeB, @golsTimeA, @golsTimeB
			END

			INSERT INTO @grupo VALUES (@nome, @disputados, @vitorias, @empate, @derrotas, @golsMarcados, @golsSofridos, @saldoGols, 
										@pontos)

			CLOSE c
			DEALLOCATE c

			SET @cont = @cont + 1
		END	
	RETURN
END


--FUNÇÃO QUE MOSTRA A CLASSIFICAÇÃO GERAL
CREATE FUNCTION fn_placarGeral()
RETURNS @pGeral TABLE (
nomeTime VARCHAR(50),
num_jogos_disputados INT,
vitorias INT,
empates INT,
derrotas INT,
gols_marcados INT,
gols_sofridos INT,
saldo_gols INT,
pontos INT
)
AS BEGIN
	
	INSERT INTO @pGeral select * from fn_placarGrupo('A')
	INSERT INTO @pGeral select * from fn_placarGrupo('B')
	INSERT INTO @pGeral select * from fn_placarGrupo('C')
	INSERT INTO @pGeral select * from fn_placarGrupo('D')

	RETURN
END



/*todos os times
SELECT * FROM fn_placarGeral() ORDER BY vitorias DESC, gols_marcados DESC, saldo_gols DESC
--rebaixados
select TOP(2) * from fn_placarGeral()
WHERE gols_marcados IS NOT NULL
ORDER BY vitorias ASC, gols_marcados ASC, saldo_gols ASC
*/

SELECT * FROM jogos

-- QUARTAS DE FINAL
CREATE FUNCTION fn_quartas(@grupo CHAR (1))
RETURNS @table TABLE (
nomeTime VARCHAR ( 100 )
)
AS
BEGIN
	INSERT INTO @table
	SELECT  TOP (2) nomeTime FROM fn_placarGrupo(@grupo) ORDER BY pontos DESC , vitorias DESC , gols_marcados DESC , saldo_gols DESC
	RETURN
END

--INSERIR RESULTADOS
CREATE PROCEDURE sp_Resultados1(@nomeTimeA VARCHAR(100), @nomeTimeB VARCHAR(100), @golsTimeA INT, @golsTimeB INT, @data DATE)
AS
	DECLARE @codigoTimeA INT,
			@codigoTimeB INT

	SET @codigoTimeA = (SELECT CodigoTime FROM Times WHERE NomeTime = @nomeTimeA)
	SET @codigoTimeB = (SELECT CodigoTime FROM Times WHERE NomeTime = @nomeTimeB)

	UPDATE Jogos
	SET GolsTimeA = @golsTimeA, GolsTimeB = @golsTimeB
	WHERE CodigoTimeA = @codigoTimeA AND CodigoTimeB = @codigoTimeB AND Data = @data


EXEC pro_partidasT1
select * from jogos
drop table jogos

EXEC sp_Resultados1 'Corinthians', 'Palmeiras', 1, 2, '06/02/2022'

--TRIGGER QUE NÃO PERMITE INSERT, UPDATE e DELETE NA TABELA TIMES
CREATE TRIGGER t_times ON times
FOR INSERT, UPDATE, DELETE
AS
BEGIN
	ROLLBACK TRANSACTION
	RAISERROR('Esta ação não é permitida para a tabela Times', 16, 1)
END

--TRIGGER QUE NÃO PERMITE INSERT, UPDATE e DELETE NA TABELA GRUPOS
CREATE TRIGGER t_grupos ON grupos
FOR INSERT, UPDATE, DELETE
AS
BEGIN
	ROLLBACK TRANSACTION
	RAISERROR('Esta ação não é permitida para a tabela Grupos', 16, 1)
END

--TRIGGER QUE NÃO PERMITE INSERTE e DELETE NA TABELA JOGOS
CREATE TRIGGER t_jogos ON jogos
FOR INSERT, DELETE
AS
BEGIN
	ROLLBACK TRANSACTION
	RAISERROR('Esta ação não é permitida para a tabela Jogos', 16, 1)
END
