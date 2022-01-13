--somando os valores de uma tabela SUM
select * from notafiscal n ;

-- SUM = soma o peso da tabela toda
-- AVG = faz a média aritmética simples
-- MAX = traz o peso máximo
-- MIN = traz o peso mínimo
-- COUNT = conta 
select
sum(n.pesototal) "Peso Total",
avg(n.pesototal) "Peso Médio Total",
max(n.pesototal) "Peso Total Máximo",
min(n.pesototal) "Peso Total Mínimo",
count(*) "Quantidade de Pesos"
from notafiscal n

--Calculando total de pesos por data de emissão de Nota Fiscal e ordenando por data 
select
to_char(n.dataEmissao, 'dd/mm/yyyy') "Data Emissão",
sum(n.pesototal) "Peso Total"
from notafiscal n
group by 1
order by 1

--Calculando total d pesos por mes por extensão de emissão de Nota Fiscal
--Graças ao "desc" ele coloca por extenso
select 
to_char(n.dataemissao, 'TMMonth') "Data Emissão",
sum (n.pesototal) "Peso Total"
from notafiscal n
group by 1
order by 1 desc;

--Criar uma tabela de log de faturamento
create table logFatura(
msglog varchar(80));

--Inserir um registro com Data de Emissão, Nr.Fatura, Valor Fatura
insert into logFatura (msglog) values ('Data Emissão: 22/12/2021 NF: 456877 Valor Faturado: 25568.50');

select * from logFatura l2;

--Criar uma tabela para armazenar os campos resgatados do LOG
create table resumofatura(
dataemissao Date,
nrfatura Integer,
vlrfatura decimal(8,2));

--Data Emissão:22/12/2021 NF: 456877 Valor Faturado: 25568.50
--Inserir os campos do LOG na tabela
select 
to_date(substr(l2.msglog,15,10), 'dd/mm/yyyy'),
to_number(substr(l2.msglog,POSITION('NF:' in l2.msglog)+3,7), '9999999'),
to_number(substr(l2.msglog,POSITION('Valor Faturado:' in l2.msglog)+15,9), '9g999g999.99')
from logFatura l2;

insert into resumofatura(dataemissao,nrfatura,vlrfatura) as
(select 
to_date(substr(l2.msglog,15,10), 'dd/mm/yyyy'),
to_number(substr(l2.msglog,POSITION('NF:' in l2.msglog)+3,7), '9999999'),
to_number(substr(l2.msglog,POSITION('Valor Faturado:' in l2.msglog)+15,9), '9g999g999.99')
from logFatura l2);

select * from resumofatura for update

select dataemissao,count(*)
from resumofatura a
group by a.dataemissao
having count(*)>1;