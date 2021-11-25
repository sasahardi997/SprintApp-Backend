INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');
              
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