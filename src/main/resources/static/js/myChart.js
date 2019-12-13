var processedChartData = decodeHtml(chartData);
var chartJSONArray = JSON.parse(processedChartData);

var arrayLength = chartJSONArray.length;

var numericData = [];
var labelData = [];

for(var i=0; i < arrayLength; i++) {
    numericData[i] = chartJSONArray[i].value;
    labelData[i] = chartJSONArray[i].label;
}

// For a pie chart
new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
// The data for our dataset
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f"],
            data: numericData
        }]
    },

    // Configuration options go here
    options: {
        title: {
            display: true,
            text: 'Project Statuses'
        }
    }
});

function decodeHtml(html) {
    var text = document.createElement("textarea");
    text.innerHTML = html;
    return text.value;
}