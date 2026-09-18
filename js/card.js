let cards = [];

        function getData() {

            const xhr = new XMLHttpRequest();

            xhr.open(
                "GET",
                "https://webapps.tekstac.com/WebAPI/CreditCardsXMLServlet",
                true
            );

            xhr.onreadystatechange = function () {

                if (xhr.readyState === 4) {

                    if (xhr.status === 200) {

                        const xml = xhr.responseXML;

                        cards = [];

                        const cardNodes = xml.getElementsByTagName("creditcard");

                        for (let i = 0; i < cardNodes.length; i++) {

                            const card = {
                                cardHolderName: cardNodes[i].getElementsByTagName("cardholdername")[0].textContent,
                                cardType: cardNodes[i].getElementsByTagName("cardtype")[0].textContent,
                                cardLimit: cardNodes[i].getElementsByTagName("cardlimit")[0].textContent,
                                expiryDate: cardNodes[i].getElementsByTagName("expirydate")[0].textContent
                            };

                            cards.push(card);
                        }

                        if (cards.length === 16) {
                            document.getElementById("message").innerHTML =
                                "Data retrieved successfully.";

                            displayCards();

                            document.getElementById("report").innerHTML =
                                "Report generated successfully!!!";
                        }

                    } else {
                        document.getElementById("message").innerHTML =
                            "Failed to retrieve data.";
                    }
                }
            };

            xhr.send();
        }


        function displayCards() {

            let table = "<table border='1'>";

            table += `
                <tr>
                    <th>Card Holder Name</th>
                    <th>Card Type</th>
                    <th>Card Limit</th>
                    <th>Expiry Date</th>
                </tr>
            `;

            cards.forEach(function(card) {

                table += `
                    <tr>
                        <td>${card.cardHolderName}</td>
                        <td>${card.cardType}</td>
                        <td>${card.cardLimit}</td>
                        <td>${card.expiryDate}</td>
                    </tr>
                `;

            });

            table += "</table>";

            document.getElementById("result").innerHTML = table;
        }
