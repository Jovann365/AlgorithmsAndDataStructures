Во следната задача треба да изградите неподредено (општо) дрво со N јазли, за кое ќе треба да одговорите на Q прашања од видот „колку лисја има поддрвото на избран јазол“.

Секој јазол ќе има уникатен индекс од 1 до N. Коренот на дрвото секогаш ќе има индекс 1. Сите деца ќе имаат индекси поголеми од индексите на родителите.

Влезот ќе содржи N+Q редови од видот

root 1 - Треба да го поставите коренот на дрвото да биде јазелот со индекс 1

add parent_index child_index - Треба да додадете дете јазел со индекс child_index на јазелот со индекс parent_index

ask node_index - Треба да одговорите колку листови има во поддрвото на јазелот со индекс node_index

For example: 

| Input	                                                                                                                                             | Result                 |
|----------------------------------------------------------------------------------------------------------------------------------------------------|------------------------|
| 11 <br> 5  <br> root 1 <br> add 1 2 <br>add 2 3 <br>ask 1 <br>add 1 4 <br>add 2 5 <br>add 3 6<br>ask 2<br>add 3 7<br>ask 1<br>add 1 8<br>add 4 9<br>add 2 10<br>add 4 11<br>ask 2<br>ask 1 | 1 <br>2<br>4<br>4<br>7 |