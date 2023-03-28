Query 01

Comentários: Seleciona-se a coluna desejada, aplica-se a função count e 
define-se a coluna como quantidade a partir da tabela employees.employees;
O Where foi uma tentativa de utilizar apenas a tabela apresentada e não todas,
por alguma razão foi apresentado um valor a mais que as linhas apresentadas
e como apresentado na foto não sei se era esse o objetivo... por fim, apresentei por um grupo
gender, que é o que é solicitado.

Código:

Select gender,COUNT(distinct emp_no) as quantidade
From employees.employees
WHERE emp_no IN (SELECT emp_no FROM employees.employees)
Group By gender;



Query 02

Comentários: Seleciona-se as colunas pedidas pela task, em seguida renomeou-se
as colunas e foi acrescentada uma de idade pelo recurso da função CURDATE, pega o presente
e subtrai-se com o ano de nascimento. Em seguida, fez-se uma contagem com distinção
no emp_no pois poderia haver um caso de que o funcionário acabe saindo e voltando
contando duas vezes ou mais. Por fim, apresentou-se as colunas por grupo gender,
ano_entrada, ano_nascimento e idade.

Código:

SELECT gender, YEAR(hire_date) as ano_entrada,
YEAR(birth_date) as ano_nascimento,YEAR(CURDATE()) - YEAR(birth_date) as idade,
COUNT(DISTINCT emp_no) as quantidade
FROM employees.employees
GROUP BY gender, ano_entrada, ano_nascimento, idade;



Query 03

Comentários: Como não havia uma tabela já pronta, apenas a do mayk_teste, decidi
unir as tabelas de funcionários com a de salários ja existente através do recurso
JOIN ... ON ... = novatabela (Com uma comparada de emp_no).
Em seguida, foi usar as funções de média, min e max que o SQL fornece.
Por fim, aprasentou-se conforme foi pedido a task.

Código:

SELECT
employees.employees.gender,
AVG(employees.salaries.salary) AS media,
MIN(employees.salaries.salary) AS minimo,
MAX(employees.salaries.salary) AS maximo
FROM employees.employees
JOIN employees.salaries ON employees.employees.emp_no = salaries.emp_no
GROUP BY employees.employees.gender;