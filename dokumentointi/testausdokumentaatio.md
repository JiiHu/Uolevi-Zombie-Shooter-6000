Luokkia on testattu automaattisella testauksella mahdollisimman kattavasti. UI:ta ei ole testattu testeillä, mutta olen testannut sitä itse pelaamalla peliä. 

### Koodikatselmoinnissa ilmenneitä asioita

##### "Vastukset pakkaantuvat aika nopeasti yhteen nippuun, jolloin väistely muuttuu todella helpoksi."
- Tuo on totta alemmilla tasoilla, mutta onneksi peli alkaa käydä todella hankalaksi kun pelaa muutaman Levelin eteenpäin ja Zombeja tulee joka suunnasta sen verran, että niitä on vaikea väistellä pakkaantumisesta huolimatta. Kokeilin tämän korjaamista aikaisemmin, mutta se aiheutti erinäisiä ongelmia, joten jätin pakkaantumisen pelin ominaisuudeksi.

##### "Edellisessä katselmoinnissa havaittu bugi nopeuden muutoksesta liikkuessa kulmittain kummittelee yhä. Tämä näkyy selkeimmin, kun laittaa vastustajat kulkemaan suoraa linjaa."
- Bugihan johtuu siitä että kulmittain ollessa Zombie liikkuu kahteen suuntaan yhden sijaan. Koska kaikkien hahmojen liikkuminen on toteutettu pikselikartassa, en keksi mitään tapaa jolla voisi liikkua esimerkiksi vain 0.7 pikseliä nurkkaan päin. Koska pelaaja voi kuitenkin liikkua itsekin nopeammin menemällä kulmittain, en koe että tämä olisi kovinkaan suuri ongelma. Asian voisi toki korjata niin että hahmot voivat liikkua vain yhteen suuntaan kerrallaan ja sanoa että se on ominaisuus, mutta minusta tekemäni tapa on kuitenkin pelattavuuden kannalta parempi tapa.

##### "Jotkut logiikan testit eivät tunnu kovin kattavilta":
    @Test
    public void mousePositionWorks() {
    int angle = player.getAngle();
    ic.mousePosition(100, 100);
    assertTrue(angle != player.getAngle());

- Jotkin testit voisivat olla kattavampia. On kuitenkin vaikea konstruoida kaikkia mahdollisia tilanteita ja esimerkiksi juuri tarkastelemassasi esimerkissä laskea missä kulmassa Playerin pitäisi olla suhteessa hiireen, joten varmistan vain että se toimii jossain määrin. Jos taas jokin koodimuutos rikkoisi pelaajan kääntymisen kokonaan, sen huomaisi heti pelatessa.
