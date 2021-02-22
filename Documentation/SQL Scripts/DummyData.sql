select * from users;
select * from pets;
select * from posts;

insert into posts (id, author, caption) values (-10, -10, 'This is my turtle, Atlas!');
insert into posts (id, author, caption) values (-11, -11, 'Here is Noah having a good time in the mud!');


insert into users (id, email, username, account_password, bio) values (-10, 'lukemouton@fake.com', 'lukemouton', 'lmpass', 'My name is Luke Mouton');
insert into users (id, email, username, account_password, bio) values (-11, 'gregpauloski@fake.com', 'gregpauloski', 'gppass', 'My name is Greg Pauloski');
insert into users (id, email, username, account_password, bio) values (-12, 'charliemann@fake.com', 'charlesmann', 'cmpass', 'My name is Charles Mann');
insert into users (id, email, username, account_password, bio) values (-13, 'milotran@fake.com', 'milotran', 'mtpass', 'My name is Milo Tran');
insert into users (id, email, username, account_password, bio) values (-14, 'tommyyi@fake.com', 'tommyyi', 'typass', 'My name is Tommy Yi');
insert into users (id, email, username, account_password, bio) values (-15, 'ryansun@fake.com', 'ryansun', 'rspass', 'My name is Ryan Sun');
insert into users (id, email, username, account_password, bio) values (-16, 'haroonalli@fake.com', 'haroonalli', 'hapass', 'My name is Haroon Alli');
insert into users (id, email, username, account_password, bio) values (-17, 'celestegarcia@fake.com', 'celestegarcia', 'cgpass', 'My name is Celeste Garcia');
insert into users (id, email, username, account_password, bio) values (-18, 'annabasile@fake.com', 'annabasile', 'abpass', 'My name is Anna Basile');
insert into users (id, email, username, account_password, bio) values (-19, 'megansolomon@fake.com', 'megansolomon', 'mspass', 'My name is Megan Solomon');
insert into users (id, email, username, account_password, bio) values (-20, 'mikayladoh@fake.com', 'mikayladoh', 'mdpass', 'My name is Mikayla Doh');
insert into users (id, email, username, account_password, bio) values (-21, 'yvesnguyen@fake.com', 'yvesnguyen', 'ynpass', 'My name is Yves Nguyen');
insert into users (id, email, username, account_password, bio) values (-22, 'lilyferguson@fake.com', 'lilyferguson', 'lfpass', 'My name is Lily Ferguson');
insert into users (id, email, username, account_password, bio) values (-23, 'hujongolden@fake.com', 'hujongolden', 'hgpass', 'My name is Hujon Golden');
insert into users (id, email, username, account_password, bio) values (-24, 'diamondwilson@fake.com', 'diamondwilson', 'dwpass', 'My name is Diamond Wilson');

insert into pets (id, pet_name, pet_tag, bio, pet_owner) values (-10, 'Atlas', 'mr_atlas', 'I am a tortoise', -10);
insert into pets (id, pet_name, pet_tag, bio, pet_owner) values (-11, 'Checkers', 'kitty_checkers', 'I am a cat', -10);
insert into pets (id, pet_name, pet_tag, bio, pet_owner) values (-12, 'Noah', 'noahwoof', 'I am a golden retriever', -11);
insert into pets (id, pet_name, pet_tag, bio, pet_owner) values (-13, 'Kylo', 'kylobark', 'I am goldfish', -12);
insert into pets (id, pet_name, pet_tag, bio, pet_owner) values (-14, 'Lulu', 'lulupix', 'I am a hamster', -13);
insert into pets (id, pet_name, pet_tag, bio, pet_owner) values (-15, 'Sweeny', 'SweenyTodd', 'I am a parrot', -13);
insert into pets (id, pet_name, pet_tag, bio, pet_owner) values (-16, 'Jett', 'jettfast', 'I am a red robin', -14);
insert into pets (id, pet_name, pet_tag, bio, pet_owner) values (-17, 'Cat', 'ryanscat', 'I dont have a cat', -15);
insert into pets (id, pet_name, pet_tag, bio, pet_owner) values (-18, 'Kench', 'kenchbench', 'I am a chihuahua', -16);
insert into pets (id, pet_name, pet_tag, bio, pet_owner) values (-19, 'Kloe', 'cutiekloe', 'I am a pomeranian', -17);
insert into pets (id, pet_name, pet_tag, bio, pet_owner) values (-20, 'Honey', 'honeybee', 'I am a mix chihuahua and bulldog', -17);
insert into pets (id, pet_name, pet_tag, bio, pet_owner) values (-21, 'Baxter', 'barkbax', 'I am a golden retreview', -17);
insert into pets (id, pet_name, pet_tag, bio, pet_owner) values (-22, 'Que', 'quethelizard', 'Hello! I am a green lizard!', -18);
insert into pets (id, pet_name, pet_tag, bio, pet_owner) values (-23, 'Goldeneye', 'goldenthefish', 'Glub glub, I am the goldfish', -18);
insert into pets (id, pet_name, pet_tag, bio, pet_owner) values (-24, 'Slytherin', 'slimeyslither', 'Slytherin into your life. . .', -19);
insert into pets (id, pet_name, pet_tag, bio, pet_owner) values (-25, 'Buddy', 'bestbuddy', 'Megans Best Buddy and professional dog!', -19);
insert into pets (id, pet_name, pet_tag, bio, pet_owner) values (-26, 'Sneaky', 'sneakysnack', 'I am a very sneaky rattle snake', -20);
insert into pets (id, pet_name, pet_tag, bio, pet_owner) values (-27, 'Bunny', 'BaaadBunny', 'I am actually a goat, not a bunny. Fooled you.', -20);
insert into pets (id, pet_name, pet_tag, bio, pet_owner) values (-28, 'Mr. Muffin', 'bunnyhoney', 'A bunny with a little extra weight around the edges', -21);
insert into pets (id, pet_name, pet_tag, bio, pet_owner) values (-29, 'Flash', 'flashfast', 'The top race tortoise in the country', -22);
insert into pets (id, pet_name, pet_tag, bio, pet_owner) values (-30, 'Cheese', 'cheesemoo', 'Cow famous for producing some killer cheese', -22);
insert into pets (id, pet_name, pet_tag, bio, pet_owner) values (-31, 'Sammy', 'SingingSam', 'Canary with an affinity for musicals and the opera', -23);
insert into pets (id, pet_name, pet_tag, bio, pet_owner) values (-32, 'Woody', 'toystory', 'A pony fit for a cowboy. Pixar loves me', -23);
insert into pets (id, pet_name, pet_tag, bio, pet_owner) values (-33, 'Remy', 'ratatouille', 'A hamster that does not know how to cook.... yet', -24);
insert into pets (id, pet_name, pet_tag, bio, pet_owner) values (-34, 'Tibo', 'Tdog', 'A pitbull that loves to eat', -24);