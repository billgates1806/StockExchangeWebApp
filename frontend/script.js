const BASE = "http://localhost:8080";

function buy() {
    let id = accId.value;
    let s = symbol.value;
    let q = qty.value;

    fetch(`${BASE}/buy?acc=${id}&symbol=${s}&qty=${q}`)
        .then(r => r.text())
        .then(t => output.textContent = t);
}

function sell() {
    let id = accId.value;
    let s = symbol.value;
    let q = qty.value;

    fetch(`${BASE}/sell?acc=${id}&symbol=${s}&qty=${q}`)
        .then(r => r.text())
        .then(t => output.textContent = t);
}

function portfolio() {
    let id = accId.value;

    fetch(`${BASE}/portfolio?acc=${id}`)
        .then(r => r.text())
        .then(t => output.textContent = t);
}
