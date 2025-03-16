# mhornosCollections

### Funcionalitats:
- afegir productes al carret (alimentació, tèxtil i electrònica)
- passar per caixa i veure el tiquet amb el total
- control d'errors perquè el programa no peti.
- ús de map i list per gestionar els productes
- menú fàcil d'usar.
  

He fet servir 4 packages (exceptions, model, vista, controlador)

Les exceptions s'asseguren que el programa no peti si l'usuari posa alguna cosa malament

Les he posat totes en un fitxer i les crido amb try catch i throw new exception. cadascuna té el seu missatge definit.

Per buscar i gestionar productes, faig servir un `map<string, producte>`, on la clau és el codi de barres. també he fet `getProductesQuantitats()` per comptar quants productes hi ha, i ho faig amb lambda perquè sigui més ràpid.

Quan passes per caixa, es genera un tiquet amb tots els productes i el preu total.

### He afegit una opció extra al menú (opció 4) per provar el buscador de productes pel codi de barres en el carret.

