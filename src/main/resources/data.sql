
              
INSERT INTO user (id, user_name, password, role)
	VALUES (1,'miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','ADMIN');
INSERT INTO user (id, user_name, password, role)
	VALUES (2, 'tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','USER');
INSERT INTO user (id, user_name, password, role)
	VALUES (3, 'petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','USER');
              
INSERT INTO sprint(id, name, total_points) VALUES(1, "Sprint 1", 11);
INSERT INTO sprint(id, name, total_points) VALUES(2, "Sprint 2", 6);
INSERT INTO sprint(id, name, total_points) VALUES(3, "Sprint 3", 9);
INSERT INTO sprint(id, name, total_points) VALUES(4, "Sprint 4", 6);
INSERT INTO sprint(id, name, total_points) VALUES(5, "Sprint 5", 12);

INSERT INTO state(id, name) VALUES(1, "New");
INSERT INTO state(id, name) VALUES(2, "In Progress");
INSERT INTO state(id, name) VALUES(3, "Done");

INSERT INTO task(id, name, indebted, points, sprint_id, state_id) VALUES (1, "AWS", "Nikola", 6,2, 1);
INSERT INTO task(id, name, indebted, points, sprint_id, state_id) VALUES (2, "Azure", "Marko", 9, 3, 1);
INSERT INTO task(id, name, indebted, points, sprint_id, state_id) VALUES (3, "SQL", "Aleksandar",6 ,4, 2);
INSERT INTO task(id, name, indebted, points, sprint_id, state_id) VALUES (4, "MongoDB", "John", 12, 5,  3);
INSERT INTO task(id, name, indebted, points, sprint_id, state_id) VALUES (5, "Client-side", "Nelson", 11, 1, 2);