let magicCardData = {};
let magicApiUrl = 'https://api.magicthegathering.io/v1/cards';

function getMagicCardInfo() {
    fetch(magicApiUrl).then((response) => {return response.json();})
    .then((data) => {
        magicCardData = data.cards;
        $.each(magicCardData, (index, Card) => {
            let cardName = Card.name;
            let cardCost = Card.manaCost;
            console.log(cardName, cardCost);
        });
    });
}