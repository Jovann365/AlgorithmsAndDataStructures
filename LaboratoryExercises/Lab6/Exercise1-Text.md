Во оваа задача ќе работите со два објекти „Вработени“ и „Проекти“.

Еден вработен е дефиниран со 2 вредности: Име (String), Возраст (цел број).

Еден проект е дефиниран со 2 вредности: Работно Време (цел број), Плата по час (цел број).

За даден проект вкупната плата се пресметува како производ на работното време и платата по час.

Вработените ќе добиваат понудени проекти, и треба да го изберат проектот од кој ќе добијат најголема плата (доколку имаат избор од повеќе проекти со иста најголема плата, тогаш првиот таков).

Ваша задача ќе биде да им помогнете на вработените со тоа што ќе искористите CBHT со 10 кофички каде што за секој вработен ќе ја чувате неговата најдобра понуда.

За хеш функција користете производ од возраста на вработениот и ASCII вредноста на првата буква од името на вработениот.

Влез:
Во првиот ред е даден еден цел број N кој го означува бројот на понуди. Потоа во следните N редови се дадени по 4 вредности, информациите за понудите, името и возраста на вработениот и работното време и платата од час на проектот соодветно:

N<br>
name_1 age_1 time_1 rate_1<br>
name_2 age_2 time_2 rate_2<br>
...<br>
name_N age_N time_N rate_N<br>
Излез:  

Отпечатете ја целата табела (со готовиот toString метод).

Секој вработен да се печати во формат "<name, age>" каде на местото на name и age треба да стои името и возраста на вработениот соодветно (имплементирајте го ова во toString метод)

Секој проект да се печати во формат "<time, rate>" каде на местото на time и rate треба да стои работното време и платата по час на проектот соодветно (имплементирајте го ова во toString метод)

-----------------------------------

In this task, you will work with two objects "Employees" and "Projects".

An employee is defined with 2 values: Name (String), Age (integer).

A project is defined with 2 values: Working Time (integer), Hourly Salary (integer).

For a given project, the total salary is calculated as the product of the working time and the hourly salary.

Employees will be offered projects, and they should choose the project from which they will receive the highest salary (if they have a choice of multiple projects with the same highest salary, then the first one).

Your task will be to help employees by using CBHT with 10 buckets where for each employee you will store their best offer.

For the hash function, use the product of the employee's age and the ASCII value of the first letter of the employee's name.

Input:
The first line contains an integer N that indicates the number of offers. Then, in the next N rows, 4 values ​​are given, the information about the offers, the name and age of the employee and the working hours and hourly wage of the project respectively:

N<br>
name_1 age_1 time_1 rate_1<br>
name_2 age_2 time_2 rate_2<br>
...<br>
name_N age_N time_N rate_N<br>
Output:

Print the entire table (with the ready-made toString method).

Each employee should be printed in the format "<name, age>" where in place of name and age should be the name and age of the employee respectively (implement this in the toString method)

Each project should be printed in the format "<time, rate>" where in place of time and rate should be the working hours and hourly wage of the project respectively (implement this in the toString method)


For example:

| Input |	Result |
| ----- | ------ |
|5 <br> Martin 25 3 100 <br> Jana 26 4 90 <br> Martin 25 5 120 <br> Jana 26 2 95 <br> Nenad 20 6 80 | 0:<<Nenad, 20>,<6, 80>> <br> 1: <br> 2: <br> 3: <br> 4:<<Jana, 26>,<4, 90>> <br> 5:<<Martin, 25>,<5, 120>> <br> 6: <br> 7: <br> 8: <br> 9:
|1 <br> Toni 45 10 500 <br> Toni 42 30 600 <br> Ana 20 10 300 <br> Jana 20 15 350 | 0:<<Toni, 45>,<10, 500>> <br> 1: <br> 2: <br> 3: <br> 4: <br> 5: <br> 6: <br> 7: <br> 8: <br> 9: |