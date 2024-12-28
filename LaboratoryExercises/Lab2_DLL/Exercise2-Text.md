Дадена е двострано поврзана листа од цели броеви. Дополнително, дадени се и уште еден цел број M и еден природен број k. Треба да се најде првото појавување на M во листата и тој број да се помести k места на лево.

Влез: Во првиот ред од влезот е даден бројот на елементи во листата - N, па во следните следниот ред самите елементи одделени со празно место. На крај, во последните два реда дадени се целиот број M и природниот број k.

Излез: На излез треба да се испечати листата пред и после промената.

You are given a doubly-linked list of integers. Additionally, there is one more integer M and a natural number k. You need to find the first occurence of M in the list and move that node k times to the left.

Input: The first number in the input is the number of integers in the list - N, then in the next line the elements are given, separated by spaces. Then, in the last two lines, the integer M and the natural number k are given.

Output: The list before and after the transformation

For example:  

| Input | Output |
| ----- | ------ |
| 5 <br> 1 2 3 4 5 <br> 3 <br> 2 | 1<->2<->3<->4<->5 <br> 3<->1<->2<->4<->5 |
| 9 <br> 5 3 8 6 2 4 1 9 7 <br> 4 <br> 7 | 5<->3<->8<->6<->2<->4<->1<->9<->7 <br> 5<->3<->8<->6<->2<->1<->9<->4<->7 |
| 10 <br> 1 2 3 4 5 6 7 8 9 10 <br> 11 <br> 7 | 1<->2<->3<->4<->5<->6<->7<->8<->9<->10 <br>Elementot ne postoi vo listata <br> 1<->2<->3<->4<->5<->6<->7<->8<->9<->10 |