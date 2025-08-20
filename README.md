# 🎲 Projet Java — Implémentation du jeu *Yahtzee procédural*

L’objectif de ce projet est de construire progressivement (en 5–7 semaines) une **version simplifiée du jeu Yahtzee**, d’abord en **programmation procédurale**, puis en transitionnant vers une version **orientée objet** quand les bases seront maîtrisées.

---

## 💻 **Procédé de développement**
- Cloner le projet de base vide selon l'assignment GitHub Classroom.
- Créer une branche à chaque nouveau jalon.
- N'oubliez pas de faire un commit et push à chaque fois que vous terminez quelque chose.
- Faites valider régulièrement votre code à l'enseignant. Chaque étape au sein d'un jalon peut être validée.

---

## 📌 **But du jeu**

Marquer **le maximum de points** après **5 manches** de jeu, en lançant 5 dés et en réalisant la meilleure **combinaison possible** à chaque manche, parmi une liste classique de 8 combinaisons.

---

## 🔁 **Déroulement d’une manche**

1. Le joueur lance **5 dés**.
2. Il peut **relancer certains dés**, jusqu’à un total de **3 lancers maximum** (1er + 2 relances).
3. Après ses lancers, il choisit **UNE combinaison** dans laquelle inscrire son résultat.
   > ⚠️ Chaque combinaison n’est choisissable **qu’une seule fois par partie**.
4. Le score est ajouté au **total général**.
5. Après **5 manches**, on annonce le **score final**.

---

## 🧩 **Combinaisons possibles et scores**

| Combinaison      | Condition                           | Score attribué  |
|------------------|-------------------------------------|-----------------|
| Une paire         | 2 dés identiques                    | **5 pts**       |
| Deux paires       | 2×2 dés identiques                 | **10 pts**      |
| Brelan           | 3 dés identiques                    | Somme des 3 dés |
| Carré            | 4 dés identiques                    | Somme des 4 dés |
| Full House       | 3 identiques + 2 identiques          | 25 pts          |
| Petite suite     | 4 dés consécutifs (ex: 1–4, 2–5…)    | 30 pts          |
| Grande suite     | 5 dés consécutifs (ex: 1–5 ou 2–6)   | 40 pts          |
| Yahtzee          | 5 dés identiques                    | 50 pts          |

---

## 🛠️ **Plan de développement du projet (jalons à valider)**

### 🟦 JALON 1 — Génération des dés

🎯 *Objectif : comprendre Random, tableaux, affichage*
- Tirer aléatoirement un dé (1..6)
- Étendre à 5 dés stockés dans un tableau
- Afficher correctement les 5 dés avec leurs positions

---

### 🟦 JALON 2 — Relances interactives

🎯 *Objectif : interaction clavier & boucles*
- Demander à l’utilisateur quels dés il souhaite relancer
- Relancer uniquement ces positions
- Autoriser **jusqu’à trois lancers maximum par manche**

---

### 🟦 JALON 3 — Système de scoring

🎯 *Objectif : analyser les valeurs tirées*
- Compter le nombre d’occurrences de chaque face
- Détecter les 8 combinaisons du tableau
- Calculer les scores correspondants

---

### 🟦 JALON 4 — Choix unique de combinaison

🎯 *Objectif : mémoriser les combinaisons déjà jouées*
- Afficher uniquement les combinaisons encore disponibles
- L’utilisateur choisit celle à utiliser pour marquer des points
- Supprimer cette combinaison pour les manches suivantes

---

### 🟦 JALON 5 — Partie complète

🎯 *Objectif : boucles imbriquées & finalisation*
- Exécuter **5 manches** successives
- Réafficher à chaque fois le score total
- Annoncer le **score final** à la fin de la partie

---

## 💡 **Conseils techniques**

- Découpez bien votre programme en **fonctions** compréhensibles et réutilisables.
- Respectez un nommage clair (`tirage()`, `afficherDes()`, `calculerScore()`, etc.).
- Évitez les grosses fonctions « couteau suisse ».
- Le code doit rester **lisible, factorisé et commenté**.

--- 

*Bon courage ! Ce projet vous fera progresser dans :*  
➡️ les **tableaux**, les **boucles**, les **fonctions**, le **Scanner**, la logique de jeu, et posera les bases pour la suite en **programmation orientée objet** 💪

