<a href="README.md">
<img src="https://user-images.githubusercontent.com/30200769/116628303-33085400-a925-11eb-85d7-9bbcf3b1a791.png" width="30" alt="pt-br">
<a/>

<a href="README-ENG.md">
<img src="https://user-images.githubusercontent.com/30200769/116637950-9b623000-a93b-11eb-9eed-06f587750c48.png" width="30" alt="eng-us">
<a/>
 
# CPF-Validator

## What is a CPF?

* CPF (Individual Registration) is a document made by the brazilian Internal Revenue Service (IRS) and serves to identify taxpayers in Brazil.

* The number of a CPF has 11 digits to the total, in which the last two are denominated the verifier digits.

* CPF can be represented in two different ways:
<div align = "center">
 _ABCDEFGHIJK_ or _ABCDEFGHI-JK_ 
</div>

<hr>

## Calculating Verifier Digits J and K

### Obtaining J
In order to get J, we must multiply A, B, C, D, E, F, G, H e I for the respective constants:

<br>

<div align="center">

|A|B|C|D|E|F|G|H|I|
|---|---|---|---|---|---|---|---|---|
|x10|x9|x8|x7|x6|x5|x4|x3|x2|

</div>

<br>

The result of the sum, 10A + 9B + 8C + 7D + 6E + 5F + 4G + 3H + 2i is divided by 11.

If the remainder of the division is 0 or 1, the digit **j is equal to 0**.

For any other result the digit **J will be equal to [11 - remainder]**, where the remainder can be 2, 3, 4, 5, 6, 7, 8, 9 or 10.

In other words, if the remainder is 3, the value of J will be [11-3] = 8.

### Obtaining K

In order to get K, we must multiply A, B, C, D, E, F, G, H , I, and also J, for the respective constants:

<br>

<div align="center">

|A|B|C|D|E|F|G|H|I|J|
|---|---|---|---|---|---|---|---|---|---|
|x11|x10|x9|x8|x7|x6|x5|x4|x3|x2|

</div>

<br>

The result of the sum, 11A + 10B + 9C + 8D + 7E + 6F + 5G + 4H + 3I + 2J is divided by 11.

Again, if the remainder of the division is 0 or 1, the digit **K is equal to 0**. 

For any other result the digit **K will be equal to [11 - remainder]**,  where the remainder can be 2, 3, 4, 5, 6, 7, 8, 9 ou 10.

<hr>

## Validator Algorithm

This repository contains an algorithm that was developed by me, while I was learning about data structure and recursive functions. CPF-Validator simulates the
reading of a CPF, starting from the presupposition idea that the reader cannot get the data accurately. Therefore, the algorithm detects possible multiple
CPF's and validates the only possible correct digit combination that returns a valid CPF.

The validator calls a function that receives an array of strings, in which they represent a set of possible CPF's in the _ABCDEFGHIJK_ format that are obtained by the reader.

```
String[] conjuntoDeCpfs = new String[] {"96979990987","98974996987", "96974996981"};
Validator novoCpf = new Validator();
System.out.println(novoCpf.cpfRecursivo(conjuntoDeCpfs));
```

In the presupposition example, the reader obtained 3 possible combinations due to the digits to be similar:

* 96979990987
* 98974996987
* 96974996981

The validator does verifying the correct combination and returns the valid CPF, which in this case is the combination: 96974990987.

If there is no valid CPF, the return of the function will be an empty string.
