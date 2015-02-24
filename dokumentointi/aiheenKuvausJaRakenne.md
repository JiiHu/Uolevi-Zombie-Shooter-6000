# Uolevi Zombie Shooter 6000
## Kuvaus

Uolevi Zombie Shooter 6000 on peli jossa pelaaja pelaa Uolevina, joka taistelee zombeja vastaan erilaisilla aseilla. Peli on kuvattu ylhäältä päin ja on alustavasti kaksiulotteinen.

Pelissä Uolevia ohjaava pelaaja taistelee Zombeja vastaan samassa kentässä niin kauan kunnes peli vaikeutuu niin paljon että eteneminen muuttuu käytännössä mahdottomaksi. Aika-ajoin pelin taso kuitenkin vaihtuu numerolla isommaksi, jolloin peli muuttuu luonnollisesti vaikeammaksi. Näin pelaaja näkee kuollessaan kuinka pitkälle pääsi edelliseen pelikertaan verrattuna.

### Käyttäjät

Pelin käyttäjiä ovat peliä pelaavat henkilöt.

#### Käyttäjän toiminnot

Aloitusnäkymästä pelaaja voi käynnistää pelin ja pelata sitä niin kauan kunnes kuolee, jolloin peli siirtyy takaisin aloitusnäkymään.

Pelatessaan pelaaja voi ampua Zombeja hiiren vasemmalla painikkeella, tähdätä hiirellä sekä ohjata hahmoa WASD-näppäimillä. 

## Rakenne

Peli käynnistetään kutsumalla GameLauncher-luokan olion start()-metodia. Tämä tekee uuden ZombieGame-objektin (myöh. game), joka sisältää kaiken peliin liittyvän sekä tarvittavat Lwjgl-objektit graafisen käyttöliittymän käyttämiseen. UserInterface-luokan objekti (myöh. UI) sisältää render()-metodin, jonka sisällä olevaa koodia kutsutaan joka kerta kun peli piirtää uuden ruudun.

UI kutsuu jokaisella piirtokerralla:
- game:n play()-metodia, joka tarkistaa ettei pelaaja ole kuollut sekä liikuttaa zombeja pelaajaa lähemmäs
- InputControllerin lookForInput()-metodia, joka välittää pelaajan liikkumisen eteenpäin oikeille objekteille