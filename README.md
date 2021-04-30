<a href="README.md">
<img src="https://user-images.githubusercontent.com/30200769/116628303-33085400-a925-11eb-85d7-9bbcf3b1a791.png" width="30" alt="pt-br">
<a/>
  
<a href="README-ENG.md">
<img src="https://user-images.githubusercontent.com/30200769/116637950-9b623000-a93b-11eb-9eed-06f587750c48.png" width="30" alt="eng-us">
<a/>

# CPF-Validator

## O que é um CPF?

* O CPF (Cadastro de Pessoa Física) é um documento feito pela Receita Federal que serve para identificar os contribuintes no Brasil.

* O número de um CPF possui 11 digitos ao total, no qual os ultimos dois são denominados os _dígitos verificadores_.

* O CPF pode ser representado de duas formas:
<div align="center"> _ABCDEFGHIJK_ ou _ABCDEFGHI-JK_ </div>

<hr>

## Cálculo dos Digitos Verificadores J e K

### Obtendo J
Para obter J multiplicamos A, B, C, D, E, F, G, H e I pelas constantes correspondentes:

<br>

<div align="center">

|A|B|C|D|E|F|G|H|I|
|---|---|---|---|---|---|---|---|---|
|x10|x9|x8|x7|x6|x5|x4|x3|x2|

</div>

<br>

O resultado da soma, 10A + 9B + 8C + 7D + 6E + 5F + 4G + 3H + 2I é dividido por 11.

Se o resto da divisão for 0 ou 1, o dígito **J é igual a 0**. 

Para qualquer outro resultado o dígito **J será igual a [11 - RESTO]**, onde o resto pode ser 2, 3, 4, 5, 6, 7, 8, 9 ou 10.

Ou seja, caso o resto seja 3 o digito J será [11-3] = 8.

### Obtendo K

Para obter K multiplicamos A, B, C, D, E, F, G, H , I, e também J pelas constantes correspondentes:

<br>

<div align="center">

|A|B|C|D|E|F|G|H|I|J|
|---|---|---|---|---|---|---|---|---|---|
|x11|x10|x9|x8|x7|x6|x5|x4|x3|x2|

</div>

<br>


O resultado da soma, 11A + 10B + 9C + 8D + 7E + 6F + 5G + 4H + 3I + 2J, é dividido por 11.

Novamente, se o resto da divisão for 0 ou 1, o dígito **K é igual a 0**. 

Para qualquer outro resultado o dígito **K será igual a [11 - RESTO]**, onde o resto pode ser 2, 3, 4, 5, 6, 7, 8, 9 ou 10.


<hr>

## Algoritmo Validador

Este algoritmo foi desenvolvido durante meu aprendizado sobre estrutura de dados e recursão. O validador de CPF's simula a leitura
de um CPF, partindo da ideia pressuposta de que o leitor não consegue obter os dados com precisão. Logo, o algoritmo detecta multiplos possíveis
CPF's e valida a única possível combinação correta de digitos que retorna um CPF válido.

O Validador chama uma função que recebe um array de strings, no qual representam um conjunto de possiveis CPF's no formato _ABCDEFGHIJK_ que são obtidos pelo leitor.


```
String[] conjuntoDeCpfs = new String[] {"96979990987","98974996987", "96974996981"};
Validator novoCpf = new Validator();
System.out.println(novoCpf.cpfRecursivo(conjuntoDeCpfs));
```

No exemplo pressuposto, o leitor obteve 3 possiveis combinações devido aos digitos serem parecidos:

* 96979990987
* 98974996987
* 96974996981

O validador faz a verificação da combinação correta e retorna o CPF válido, que neste caso é a combinação: 96974990987. 

Caso não haja um CPF válido, o retorno da função será uma string vazia.

