delete from Taco_Order_Tacos;
delete from Taco_Ingredients;
delete from Taco;
delete from Taco_Order;

delete from Ingredient;
insert into Ingredient (id, name, type)
values ('FLTO', 'Flour Tortilla', 'WRAP');
insert into Ingredient (id, name, type)
values ('COTO', 'Corn Tortilla', 'WRAP');
insert into Ingredient (id, name, type)
values ('GRBF', 'Ground Beef', 'PROTEIN');
insert into Ingredient (id, name, type)
values ('CARN', 'Carnitas', 'PROTEIN');
insert into Ingredient (id, name, type)
values ('TMTO', 'Diced Tomatoes', 'VEGGIES');
insert into Ingredient (id, name, type)
values ('LETC', 'Lettuce', 'VEGGIES');
insert into Ingredient (id, name, type)
values ('CHED', 'Cheddar', 'CHEESE');
insert into Ingredient (id, name, type)
values ('JACK', 'Monterrey Jack', 'CHEESE');
insert into Ingredient (id, name, type)
values ('SLSA', 'Salsa', 'SAUCE');
insert into Ingredient (id, name, type)
values ('SRCR', 'Sour Cream', 'SAUCE');

insert into Taco (id, name, created_at)
values ('1', 'firstTaco', '2023-05-10');
insert into Taco (id, name, created_at)
values ('2', 'secondTaco', '2023-05-10');
insert into Taco (id, name, created_at)
values ('3', 'thirdTaco', '2023-05-10');

insert into Taco_Ingredients (taco_id, ingredients_id)
values ('1', 'SRCR');
insert into Taco_Ingredients (taco_id, ingredients_id)
values ('1', 'JACK');
insert into Taco_Ingredients (taco_id, ingredients_id)
values ('2', 'CHED');
insert into Taco_Ingredients (taco_id, ingredients_id)
values ('2', 'LETC');
insert into Taco_Ingredients (taco_id, ingredients_id)
values ('3', 'CHED');
insert into Taco_Ingredients (taco_id, ingredients_id)
values ('3', 'LETC');