																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																															--Atualizando uma informação do caminhão 
--Imaginando que foi trocado a placa de um caminhão que possui uma placa específica
update caminhao 
set placa = 'CXX-8844'
where placa = 'WKK-2789';

--select simples da tabela caminhão
--faz com que seja selecionado os indices informados e ordena por placa
--(como placa é String, então por ordem alfabética)
select 
c.placa "Placa", --Pode se criar apelidos para o relatorio, usando "as" ou só as aspas
to_char (c.datamanut, 'dd/mm/yyyy') as "Data Manutenção", --to_char (c2.datamanut, 'dd/mm/yyyy') faz com que apareça na sequencia certa
to_char (c.dataproxmanut, 'dd/mm/yyyy') as "Data Prox.Manutenção"
from caminhao c 
order by 1; --não precisa informar ascendente (asc) porque não é padrão
			--opção descendente (desc) tem que ser declarada

--Qual caminhão teve a data de manutenção mais recente
select c.placa, c.datamanut 
from caminhao c
where c.datamanut = (select max(datamanut) from caminhao);

--Ordenará pelo número do manifesto e quando a data de saída for null colocará a data '01/01/1900'
select 
m.nmrmanifesto "Manifesto",
m.nrnota "Nota Fiscal", 
m.pesototal "Peso Manifesto",
m.qtdvolumes "Volumes Manifesto",
to_char (m.dataembarque , 'dd/mm/yyyy') as "Data Embarque",
case m.indsituacao --Especificando o apelido que aparecerá o valor inserido para "indsituacao", dependendo do caso
when 'E' then 'Embarcado'
when 'P' then 'Pendente'
when 'S' then 'Saída'
end "Situação",
to_char (coalesce(m.datasaida, '01/01/1900'),'dd/mm/yyyy') as "Data Saida"
from manifestocarga m
where m.nmrmanifesto = 1

--Usando funções de Strings
--Buscar parte do nome do motorista usando LIKE
select * from motorista m
where m.nomemotorista like 'C%'; --Deve por a inicial da letra seguido do simbolo de %