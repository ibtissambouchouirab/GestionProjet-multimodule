-- PROJECTS
INSERT INTO PROJECT( nom ,code, description )
    VALUES  ('Project MTRI','Pmtu243','big project' ),
            ('Project AIR Maroc','Pmtu2H3','Smart project' );

-- TACHES
INSERT INTO TACHE( nom ,code ,priority, Status, description )
    VALUES  ('tache MTRI','tache12345','low', 'fini', 'big project' ),
            ('Project AIR Maroc','Pmtu2H3','low', 'fini','Smart project' );


-- AGENTS
INSERT INTO AGENT( id ,matricule ,nom ,prenom ,email ,password  )
    VALUES       ( 10 ,345567 ,'ibi', 'titi', 'titi@email.com','pss@123'),
                 ( 12 ,2345565 ,'did', 'fiti', 'fiti@email.com','pss@123');