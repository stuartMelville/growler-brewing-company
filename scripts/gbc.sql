DROP TABLE growler_brewing_collective.ingredient;
DROP TABLE growler_brewing_collective.recipie;

select * from growler_brewing_collective.ingredient;
select * from growler_brewing_collective.recipie;

select * from growler_brewing_collective.ingredient i, growler_brewing_collective.recipie r
where r.id = i.recipie_id
