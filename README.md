<a id="readme-top"></a>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table des matières</summary>
  <ol>
    <li>
      <a href="#à-propos-du-projet">À propos du projet</a>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prérequis">Prérequis</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#utilisation">Utilisation</a></li>
    <li><a href="#tests">Tests</a></li>
    <li><a href="#améliorations-possibles">Améliorations possibles</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## À propos du projet

Ce projet implémente une simulation de propagation de feu de forêt selon les spécifications suivantes :

- La forêt est représentée par une **grille 2D** de dimension `h × l`
- Le temps est **discrétisé** : la simulation progresse étape par étape
- Dans l'état initial, une ou plusieurs cases sont en feu
- À chaque étape :
  - Les cases en feu deviennent des cendres
  - Le feu peut se propager aux 4 cases adjacentes avec une probabilité `p`
- La simulation s'arrête quand il n'y a plus de feu

### Exemple d'exécution

```
Simulation feu de foret
======================
Hauteur: 5
Largeur: 10
Probabilite de propagation: 0.6
Positions de feu initiales: [[0, 1], [1, 2], [2, 3]]

T T T T T T T T T T
T F T T T T T T T T
T T F T T T T T T T
T T T F T T T T T T
T T T T T T T T T T
Nombre de feux actifs: 3
Nombre d'arbres: 47
Nombre de cendres: 0

Step 1:
F A F T T T T T T T
T F A F T T T T T T
T T F A F T T T T T
T T T T T T T T T T
T T T T T T T T T T
Nombre total de feux actifs: 6
Nombre d'arbres: 41
Nombre de cendres: 3
```

**Légende :**
- `T` = Arbre (Tree)
- `F` = Feu (Fire)
- `A` = Cendre (Ash)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

### Prérequis

* **Java 8 ou supérieur** 
* **Maven**

### Installation

1. Cloner le repo
   ```sh
   git clone https://github.com/yassineelhaouat/forest_sim_ciril.git
   cd forest_sim_ciril
   ```

2. Compiler le projet
   ```sh
   mvn clean compile
   ```

3. Configurer la simulation dans `src/main/resources/config.properties`
   ```properties
   # Dimensions de la grille
   forest.height=5
   forest.width=10
   
   # Probabilité de propagation (entre 0 et 1)
   fire.propagationProbability=0.6
   
   # Positions initiales du feu (format: (x,y) (x,y) ...)
   fire.initialFires=(0,1) (1,2) (2,3)
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- USAGE -->
## Utilisation

### Lancer la simulation

```sh
mvn exec:java
```

### Générer un JAR exécutable

```sh
mvn clean package
java -jar target/forest_sim_ciril-1.0-SNAPSHOT.jar
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>


### Exécuter les tests

```sh
mvn test
```
<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ROADMAP -->
## Améliorations Possibles

- **Interface graphique**
- **Ajout d'obstacles et de nouveaux paramètres**
- **Optimisations pour grilles larges**

<p align="right">(<a href="#readme-top">back to top</a>)</p>
