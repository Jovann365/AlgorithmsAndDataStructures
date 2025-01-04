Еден новооснован град треба да ги поврзе населбите со патишта. Градоначалникот сака да осигура дека секоја населба ќе биде достапна од која било друга населба, но притоа трошоците за изградба на патиштата да бидат минимални. Дадена е листа на можни патишта и цената за изградба на секој пат. Да се одреди минималната цена да се поврзат сите населби.

Влез: Во првиот ред е даден бројот на населби N. Потоа во следните N редови се дадени имињата на населбите. Во следниот ред е даден бројот на можни патишта M, а потоа во следните M редови се дадени населбите што ги поврзува секој пат и цената за изградба на тој пат.

Излез:  Минималната цена да се поврзат сите патишта.

Пример:

Влез:

4<br>
Downtown<br>
Uptown<br>
Riverview<br>
Lakeside<br>
5<br>
Downtown Uptown 400<br>
Downtown Riverview 200<br>
Uptown Riverview 100<br>
Riverview Lakeside 500<br>
Uptown Lakeside 300<br>

Излез: 600 (Објаснување: ќе се изградат патиштата Downtown-Riverview, Uptown-Riverview и Uptown-Lakeside)

A newly established city needs to connect its neighborhoods with roads. The mayor wants to ensure that every neighborhood is accessible from any other neighborhood while minimizing the cost of building the roads. A list of possible roads and the cost of building each road is given. Determine the minimum cost to connect all neighborhoods.



Input: The first line contains the number of neighborhoods N. The next N lines contain the names of the neighborhoods. The next line contains the number of possible roads M, followed by M lines that contain the two neighborhoods connected by each road and the cost of building that road.

Output: The minimum cost to connect all neighborhoods.

Example:

Input:

4<br>
Downtown<br>
Uptown<br>
Riverview<br>
Lakeside<br>
5<br>
Downtown Uptown 400<br>
Downtown Riverview 200<br>
Uptown Riverview 100<br>
Riverview Lakeside 500<br>
Uptown Lakeside 300<br>

Output: 600 (Explanation: the roads Downtown-Riverview, Uptown-Riverview and Uptown-Lakeside will be built)


For example:

| Input	| Result |
|------|------|
|4<br>Downtown<br>Uptown<br>Riverview<br>Lakeside<br>5<br>Downtown Uptown 400<br>Downtown Riverview 200<br>Uptown Riverview 100<br>Riverview Lakeside 500<br>Uptown Lakeside 300 |600|
| 3<br>Downtown<br>Uptown<br>Riverview<br>3<br>Downtown Uptown 100<br>Uptown Riverview 200<br>Downtown Riverview 120 |220 |