$(document).ready(function () {

    $("#search-form").submit(function (event) {
        event.preventDefault();
        fire_ajax_submit();
    });

    $("#tickers").click(function(){
        getTickerSymbols();
    });

});

function fire_ajax_submit() {
    $("#divT").remove();
    var search = {}
    search["ticker"] = $("#ticker").val();

    $("#btn-search").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/v1/ticker/data",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Stock data</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}

function getTickerSymbols() {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/api/v1/tickers",
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var buffer="";
            $.each(data, function(index, val) {
                buffer += " <li><a href='#" + val + "'>" + val + "</a></li>";
            });
            $('ul').html(buffer);
            // var json = "<h4>Available Tickers</h4><pre>"
            //     + JSON.stringify(data, null, 4) + "</pre>";
            // $('#tickerData').html(json);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });
}