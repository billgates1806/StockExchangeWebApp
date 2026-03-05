function createChart(canvasId, color) {
    const ctx = document.getElementById(canvasId).getContext("2d");

    let data = [];
    for (let i = 0; i < 20; i++) data.push(100 + Math.random() * 20);

    return new Chart(ctx, {
        type: "line",
        data: {
            labels: Array(20).fill(""),
            datasets: [{
                data: data,
                borderColor: color,
                borderWidth: 2,
                pointRadius: 0,
                tension: 0.4,
                fill: false
            }]
        },
        options: {
            plugins: { legend: { display: false }},
            scales: {
                x: { display: false },
                y: { display: false }
            }
        }
    });
}

const chartAAPL = createChart("chartAAPL", "#4ade80");
const chartGOOG = createChart("chartGOOG", "#60a5fa");
const chartTSLA = createChart("chartTSLA", "#f87171");
const chartMSFT = createChart("chartMSFT", "#facc15");

setInterval(() => {
    [chartAAPL, chartGOOG, chartTSLA, chartMSFT].forEach(chart => {
        let arr = chart.data.datasets[0].data;
        arr.shift();
        let last = arr[arr.length - 1];
        arr.push(last + (Math.random() * 3 - 1.5));
        chart.update();
    });
}, 1200);
