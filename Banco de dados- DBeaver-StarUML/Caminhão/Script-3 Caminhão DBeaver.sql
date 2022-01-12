																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																															--Atualizando uma informa��o do caminh�o 
--Imaginando que foi trocado a placa de um caminh�o que possui uma placa espec�fica
update caminhao 
set placa = 'CXX-8844'
where placa = 'WKK-2789';

--select simples da tabela caminh�o
--faz com que seja selecionado os indices informados e ordena por placa
--(como placa � String, ent�o por ordem alfab�tica)
select 
c.placa "Placa", --Pode se criar apelidos para o relatorio, usando "as" ou s� as aspas
to_char (c.datamanut, 'dd/mm/yyyy') as "Data Manuten��o", --to_char (c2.datamanut, 'dd/mm/yyyy') faz com que apare�a na sequencia certa
to_char (c.dataproxmanut, 'dd/mm/yyyy') as "Data Prox.Manuten��o"
from caminhao c 
order by 1; --n�o precisa informar ascendente (asc) porque n�o � padr�o
			--op��o descendente (desc) tem que ser declarada

--Qual caminh�o teve a data de manuten��o mais recente
select c.placa, c.datamanut 
from caminhao c
where c.datamanut = (select max(datamanut) from caminhao);

--Ordenar� pelo n�mero do manifesto e quando a data de sa�da for null colocar� a data '01/01/1900'
select 
m.nmrmanifesto "Manifesto",
m.nrnota "Nota Fiscal", 
m.pesototal "Peso Manifesto",
m.qtdvolumes "Volumes Manifesto",
to_char (m.dataembarque , 'dd/mm/yyyy') as "Data Embarque",
case m.indsituacao --Especificando o apelido que aparecer� o valor inserido para "indsituacao", dependendo do caso
when 'E' then 'Embarcado'
when 'P' then 'Pendente'
when 'S' then 'Sa�da'
end "Situa��o",
to_char (coalesce(m.datasaida, '01/01/1900'),'dd/mm/yyyy') as "Data Saida"
from manifestocarga m
where m.nmrmanifesto = 1

--Usando fun��es de Strings
--Buscar parte do nome do motorista usando LIKE
select * from motorista m
where m.nomemotorista like 'C%'; --Deve por a inicial da letra seguido do simbolo de %