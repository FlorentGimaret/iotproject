//DATA
const xAxis = 'lat_N';
const yAxis = 'long_W';
const xAxisName = 'Longitude';
const yAxisName = 'Latitude';
/* $GPGLL,4916.45,N,12311.12,W,225444,A,*1D
#
# Where:
#     GLL          Geographic position, Latitude and Longitude
#     4916.46,N    Latitude 49 deg. 16.45 min. North
#     12311.12,W   Longitude 123 deg. 11.12 min. West
#     225444       Fix taken at 22:54:44 UTC
#     A            Data Active or V (void)
#     *iD          checksum data
*/
const testData = {
    0: {
        'lat_N': 4116.45,
        'long_W': 2311.12,
    },
    1: {
        'lat_N': 4216.45,
        'long_W': 3311.12,
    },
    2: {
        'lat_N': 4316.45,
        'long_W': 5311.12,
    },
    3: {
        'lat_N': 4416.45,
        'long_W': 6311.12,
    },
    4: {
        'lat_N': 4516.45,
        'long_W': 7311.12,
    },
    5: {
        'lat_N': 5016.45,
        'long_W': 8311.12,
    },
    6: {
        'lat_N': 5116.45,
        'long_W': 9311.12,
    },
    7: {
        'lat_N': 5216.45,
        'long_W': 10311.12,
    },
    8: {
        'lat_N': 5316.45,
        'long_W': 11311.12,
    },
    9: {
        'lat_N': 5416.45,
        'long_W': 12311.12,
    },
    10: {
        'lat_N': 16.45,
        'long_W': 13311.12,
    },
};

var xAxisData = [];
var yAxisData = [];

for(let i = 0; i < testData.length; i++){
    xAxisData.push(testData[i][xAxis]);
    yAxisData.push(testData[i][yAxis]);
}

/*testData.forEach((entry) =>{
xAxisData.push(entry[xAxis]);
yAxisData.push(entry[yAxis]);
});*/

//    live chart
$(function () {
    // we use an inline data source in the example, usually data would
    // be fetched from a server
    var data = [], totalPoints = 300;
    function getRandomData() {
        if (data.length > 0)
            data = data.slice(1);

        // do a random walk
        while (data.length < totalPoints) {
            var prev = data.length > 0 ? data[data.length - 1] : 50;
            var y = prev + Math.random() * 10 - 5;
            if (y < 0)
                y = 0;
            if (y > 100)
                y = 100;
            data.push(y);
        }

        // zip the generated y values with the x values
        var res = [];
        for (var i = 0; i < data.length; ++i)
            res.push([i, data[i]])
        return res;
    }

    // setup control widget
    var updateInterval = 30;
    $("#updateInterval").val(updateInterval).change(function () {
        var v = $(this).val();
        if (v && !isNaN(+v)) {
            updateInterval = +v;
            if (updateInterval < 1)
                updateInterval = 1;
            if (updateInterval > 2000)
                updateInterval = 2000;
            $(this).val("" + updateInterval);
        }
    });

    // setup plot
    var options = {
        series: { shadowSize: 0 }, // drawing is faster without shadows
        yaxis: { min: 0, max: 100 },
        xaxis: { show: false }
    };
    var plot = $.plot($("#chart"), [ getRandomData() ], options);

    function update() {
        plot.setData([ getRandomData() ]);
        // since the axes don't change, we don't need to call plot.setupGrid()
        plot.draw();

        setTimeout(update, updateInterval);
    }

    update();
});