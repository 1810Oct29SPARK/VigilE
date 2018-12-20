let magicCardData = {};
let magicTestUrl = 'https://api.scryfall.com/cards/';
let magicApiSearchUrl = 'https://api.scryfall.com/cards/search';

function searchMagicApi() {
    let cardName = document.getElementById("inputCardName").value;
    let cardText = document.getElementById('inputText').value;
    let cardType = document.getElementById('inputCardType').value;
    let cardCMC = document.getElementById('inputCMC').value;
    let cardPower = document.getElementById('inputPower').value;
    let cardTough = document.getElementById('inputTough').value;
    let cardLegal = document.getElementById('inputLegal').value;


    let searchTerms = "?q=";
    let searchString = "";

    if (cardName) {
        nameWords = cardName.split(" ");
        for (w = 0; w < nameWords.length; w++) {
            searchString="";
            searchString = searchString + nameWords[w] + "+";
            searchTerms += searchString
        }
        console.log (searchTerms);
    }
        
        if (cardText) {
            textWords = cardText.split(" ");
            for (w = 0; w < textWords.length; w++) {
                searchString = "oracle%3A";
                searchString = searchString + textWords[w] + "+"; 
                searchTerms += searchString;
            }
            console.log (searchTerms);
        }
        if (cardType) {
            typeWords = cardType.split(" ");
            for (w = 0; w < typeWords.length; w++) {
                searchString = "type%3A";
                searchString = searchString + typeWords[w] + "+"; 
                searchTerms += searchString;
            }
            console.log (searchTerms);
        }
        if (cardCMC) {
            searchString = "cmc%3D";
            searchString = searchString + cardCMC + "+";
            searchTerms += searchString;
            console.log(searchTerms);
        }
        if (cardPower) {
            searchString = "pow%3D";
            searchString = searchString + cardPower + "+";
            searchTerms += searchString;
            console.log(searchTerms);

        }
        if (cardTough) {
            searchString = "tou%3D";
            searchString = searchString + cardTough + "+";
            searchTerms += searchString;
            console.log(searchTerms);
        }
        if (cardLegal) {
            legalWords = cardLegal.split(" ");
            for (w = 0; w < legalWords.length; w++) {
                searchString = "legal%3A";
                searchString = searchString + legalWords[w] + "+"; 
                searchTerms += searchString;
            }
            console.log (searchTerms);

        }

        fetch (magicApiSearchUrl + searchTerms)
        /*'?q=' + inputcardName + "+oracle%3A" + inputText + "+type%3A" + inputCardType + "+color%3D" + inputColors + "+commander%3D" + inputCommander + "+mana%3A" + inputManaSymbols + "+cmc%3D" + inputCMC + "+legal%3A" + inputLegal + "+pow%3D" + inputPower + "+tou%3D" + inputTough) */
        .then(function(response) {
            return response.json();
        })
        .then(function(myJson) {
            let cards = myJson.data;
        //let output = " ";
        
            console.log(cards);

            for (i = 0; i < cards.length; i++) {
                if (cards[i].image_uris){
                console.log(cards[i].image_uris.normal);
                }
                else {
                console.log("Image Not Found");
                }
            }      
        });
};

$('#searchSubmit').click(function () {
    searchMagicApi();
});

/*
document.querySelector('#txtSearch').addEventListener('keypress', function (e) {
    var key = e.which || e.keyCode;
    if (key === 13) { // 13 is enter
      // code for enter
    }
});
*/

function buildSearchMagicApi() {
    let cardName = document.getElementById("inputBuilderName").value;
    let cardText = document.getElementById('inputBuilderText').value;
    let cardType = document.getElementById('inputBuilderType').value;


    let searchTerms = "?q=";
    let searchString = "";

    if (cardName) {
        nameWords = cardName.split(" ");
        for (w = 0; w < nameWords.length; w++) {
            searchString="";
            searchString = searchString + nameWords[w] + "+";
            searchTerms += searchString
        }
        console.log (searchTerms);
    }
        
        if (cardText) {
            textWords = cardText.split(" ");
            for (w = 0; w < textWords.length; w++) {
                searchString = "oracle%3A";
                searchString = searchString + textWords[w] + "+"; 
                searchTerms += searchString;
            }
            console.log (searchTerms);
        }
        if (cardType) {
            typeWords = cardType.split(" ");
            for (w = 0; w < typeWords.length; w++) {
                searchString = "type%3A";
                searchString = searchString + typeWords[w] + "+"; 
                searchTerms += searchString;
            }
            console.log (searchTerms);
        }

        fetch (magicApiSearchUrl + searchTerms)
        /*'?q=' + inputcardName + "+oracle%3A" + inputText + "+type%3A" + inputCardType + "+color%3D" + inputColors + "+commander%3D" + inputCommander + "+mana%3A" + inputManaSymbols + "+cmc%3D" + inputCMC + "+legal%3A" + inputLegal + "+pow%3D" + inputPower + "+tou%3D" + inputTough) */
    .then(function(response) {
    return response.json();
    })
    .then(function(myJson) {
        let cards = myJson.data;
        //let output = " ";
        
        console.log(cards);

        for (i = 0; i < cards.length; i++) {
            let imgLink = cards[i].image_uris;
            if (imgLink){
            console.log(imgLink.normal);
            }
            else {
                console.log("Image Not Found");
            }

        }

        console.log("cards [0]: " + cards[0].image_uris.normal);
        document.getElementById("searchCardImg").src = cards[0].image_uris.normal;
        

        
        

        /*
        $.each (cards, (index, card) => {
            console.log(card.image_uris.normal);
            output += `
            <div class="row">
                <div class="col-md-4"> 
                <img src="" class="thumbnail">
                </div>
            </div>
        `;
       */
            
    });
    /*
        $("#cards").html(output);
    });
     */
};

document.getElementById('inputBuilderName').addEventListener('keypress', function (e) {
    var key = e.which || e.keyCode;
    if (key === 13) {
        buildSearchMagicApi();
        
    }
});

document.getElementById('inputBuilderText').addEventListener('keypress', function (e) {
    var key = e.which || e.keyCode;
    if (key === 13) {
        buildSearchMagicApi();
    }
});

document.getElementById('inputBuilderType').addEventListener('keypress', function (e) {
    var key = e.which || e.keyCode;
    if (key === 13) {
        buildSearchMagicApi();
    }
});