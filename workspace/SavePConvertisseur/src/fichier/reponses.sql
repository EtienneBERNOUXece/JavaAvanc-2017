-- peuplements base de donn�es --

-- reponses --
INSERT INTO `reponses` (`id_reponse`, `intitule`, `valeur`, `question_id`)
VALUES(1,"Urgence",1,1),
(2,"Conseil m�dical",2,1),
(3,"Consciente",1,2),
(4,"Inconsciente",2,2),
(5,"Pertes de connaissance br�ves, vertiges",3,2),
(6,"Normale",1,3),
(7,"Difficult�s � respirer",2,3),
(8,"Ne respire plus",3,3),
(9,"Normal",1,4),
(10,"Acc�l�r� et irr�gulier ou d�sagr�able",2,4),
(11,"Je ne sais pas",3,4),
(12,"Douleur",1,5),
(13,"Br�lure",2,5),
(14,"Saignement",3,5),
(15,"Section d'un membre",4,5),
(16,"Ecrasement, ensevelissement",5,5),
(17,"Pas de trauma physique visible",6,5),
(18,"Complet",1,6),
(19,"Partiel",2,6),
(20,"T�te ou Cou",1,7),
(21,"Thorax",2,7),
(22,"Abdominal",3,7),
(23,"Mains ou Pieds",4,7),
(24,"Membres",5,7),
(25,"Doigts ou orteils",6,7),
(26,"Autres",7,7),
(27,"Importante",1,8),
(28,"Moyenne",2,8),
(29,"Peu",3,8),
(30,"Crachat de sang",4,8),
(31,"Aucun",5,8),
(32,"1",1,9),
(33,"2+",2,9),
(34,"Nourrisson ou enfant",1,10),
(35,"Femme enceinte",2,10),
(36,"Personne �g�e",3,10),
(37,"Personne en surpoids",4,10),
(38,"Tout fait accidentel",1,11),
(39,"Noyade",2,11),
(40,"Pendaison",3,11),
(41,"Electrocution ou foudroiement",4,11),
(42,"Personne restant � terre suite � une chute",5,11),
(43,"Tir ou accident avec plaie par arme � feu",6,11),
(44,"Accident de la circulation",7,11),
(45,"Aggression",8,11),
(46,"Aucun",9,11),
(47,"Asthme",1,12),
(48,"Cancer",2,12),
(49,"Cardiaque",3,12),
(50,"Aucun",4,12),
(51,"Je ne sais pas",5,12);

-- questions_reponses --

INSERT INTO `questions_reponses` (`reponse_id`, `question_id`)
VALUES(1,2),
(2,2),
(3,3),
(4,3),
(5,3),
(6,4),
(7,4),
(8,4),
(9,5),
(10,5),
(11,5),
(12,6),
(13,6),
(14,6),
(15,6),
(16,6),
(17,6),
(18,7),
(19,7),
(20,8),
(21,8),
(22,8),
(23,8),
(24,8),
(25,8),
(26,8),
(27,9),
(28,9),
(29,9),
(30,9),
(31,9),
(32,10),
(33,10),
(34,11),
(35,11),
(36,11),
(37,11),
(38,12),
(39,12),
(40,12),
(41,12),
(42,12),
(43,12),
(44,12),
(45,12),
(46,12),
(47,-1),
(48,13),
(49,13),
(50,13),
(51,13);
