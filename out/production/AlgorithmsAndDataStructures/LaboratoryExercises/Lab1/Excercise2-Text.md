Дадена е еднострана поврзана листа чии што јазли содржат по еден String. Дополнително, даден е и уште еден природен број L. Во дадената листа пред секој јазол којшто содржи String со должина поголема од L да се вметне нов јазол со вредност "Outlier".

Влез: Во првиот ред од влезот е даден бројот на елементи во листата - N, па во следните N редови се дадени самите елементи (String-ови) од листата. На крај, во последниот ред е даден бројот L.

Излез: На излез треба да се испечати листата пред и после промената.


You are given a single linked list with String nodes. Additionally, you are given one more integer L. You need to insert a new node with value "Outlier" before each node that contains a String with more than L characters in the list.

Input: In the first line from the input the number of elements in the list is given - N, and then in the next N lines the elements themselves. In the last line, the integer L is given.

Output: The list before and after the transformation

| Input | Result |
| ------ | ------ |
| 3 <br> Sky <br> Blue <br> Cloud <br> 5 | Sky->Blue->Cloud <br> Sky->Blue->Cloud |
| 1 <br> Hello <br> 4 | Hello <br> Outlier->Hello |
| 3 <br> Big <br> Elephant <br> Small <br> 6| Big->Elephant->Small <br> Big->Outlier->Elephant->Small |
