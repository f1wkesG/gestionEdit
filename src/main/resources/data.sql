insert into UTILISATEUR(LOGIN,PASSWORD,NOM,PRENOM) VALUES ('admin','adminpass','Redacteur', 'En Chef');
insert into UTILISATEUR(LOGIN,PASSWORD,NOM,PRENOM) VALUES ('assistant','assistantpass','Assistant', 'Redacteur');
insert into UTILISATEUR(LOGIN,PASSWORD,NOM,PRENOM) VALUES ('bob','bob','Bob', 'DUPONT');
insert into ARTICLE(ID_ARTICLE,CONTENU,CONTENU_MODIFIE,ETAT,THEME,TITRE,NUMERO_NUM,UTILISATEUR_LOGIN)
VALUES ('1',
        'La majorité des personnes atteintes de la COVID-19 ne ressentiront que ' ||
        'des symptômes bénins ou modérés et guériront sans traitement particulier. ' ||
        'Cependant, certaines auront besoin de soins médicaux.',
        null,
        'ARTICLE_PROPOSE',
        'ACTUALITE',
        'Covid-19',
        null,
        'bob');
insert into ARTICLE(ID_ARTICLE,CONTENU,CONTENU_MODIFIE,ETAT,THEME,TITRE,NUMERO_NUM,UTILISATEUR_LOGIN)
VALUES ('2',
        'Activité physique exercée dans le sens du jeu et de leffort, ' ||
        'et dont la pratique suppose un entraînement méthodique et le respect de règles.',
        null,
        'ARTICLE_PROPOSE',
        'SPORT',
        'Pratiquer le sport',
        null,
        'bob');
