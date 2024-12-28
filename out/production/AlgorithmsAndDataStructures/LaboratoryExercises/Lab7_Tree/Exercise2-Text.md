Во следната задача треба да изградите бинарно дрво со N јазли, за кое ќе треба да одговорите на Q прашања од видот „која е максималната длабочина во поддрвото на избран јазол“.

Секој јазол ќе има уникатно име. Името на коренот на дрвото секогаш ќе ви биде дадено прво.

Влезот ќе содржи N+Q редови од видот

root ime - Треба да го поставите коренот на дрвото да биде јазелот со име ime

add parent_name child_name - Треба да додадете дете јазел со име child_name на јазелот со име parent_name

ask node_name - Треба да го одговориме прашањето за поддрвото на јазелот со име node_name

For example:

| Input |	Result |
| ------ | ------- |
| 11 9 <br>root bravo<br>add bravo echo LEFT<br>add echo beard LEFT<br>ask beard<br>ask bravo<br>add bravo foxtrot RIGHT<br>add beard hotel LEFT<br>add beard india RIGHT<br>ask echo<br>add foxtrot golf LEFT<br>add golf juliet RIGHT<br>add india sierra RIGHT<br>ask foxtrot<br>ask bravo<br>ask beard<br>add echo mike RIGHT<br>add foxtrot tango RIGHT<br>ask echo<br>ask bravo<br>ask foxtrot | 1<br>3<br>3<br>3<br>5<br>3<br>4<br>5<br>3 |