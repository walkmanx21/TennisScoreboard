CREATE TABLE IF NOT EXISTS Players (
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY ,
    name VARCHAR UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS Matches (
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY ,
    player1 INT REFERENCES Players(id),
    player2 INT REFERENCES Players(id),
    winner INT REFERENCES Players(id)
);

INSERT INTO Players (name)
VALUES (Sergey),
       (Ilmira),
       (Dmitry),
       (Alice),
       (Milana),
       (Ivan),
       (Maxim),
       (Denis),
       (Alexey),
       (Anton),
       (Andrey),
       (Victor);

INSERT INTO Matches (player1, player2, winner)
VALUES (1, 2, 1),
       (1,3,2),
       (2,3,2),
       (3,4,3),
       (4,5,5),
       (4,1,1),
       (5,8,8),
       (6,7,6),
       (9,10,9),
       (11,12,12),
       (12,3,3),
       (4,9,4),
       (5,1,1),
       (6,12,6),
       (10,3,3);
