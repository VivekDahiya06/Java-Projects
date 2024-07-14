console.log("Main.js working")
const populate = async(value,currency) => { 
    let myStr = "";
    url = "https://api.currencyapi.com/v3/latest?apikey=cur_live_0qNTU7sz9gvi1UAFsmkMPJ6xF5zMVYXANulrUvqo&base_currency="+currency;
    let response = await fetch(url)
    let rJson = await response.json();
    document.querySelector(".output").style.display = "block";
    for (let key of Object.keys(rJson["data"])) {
        myStr +=`<tr>
            <td>${key}</td>
            <td>${rJson["data"][key]["code"]}</td>
            <td>${Math.round(rJson["data"][key]["value"]*value)}</td>
        </tr>`
    }
    const table_body = document.querySelector("tbody");
    table_body.innerHTML = myStr;
}
const btn = document.querySelector(".btn");
btn.addEventListener("click", (ae) => {
    ae.preventDefault();
    const value = parseInt(document.querySelector("input[name='quantity']").value);
    const currency = document.querySelector("select[name='Country']").value;
    populate(value,currency);
})