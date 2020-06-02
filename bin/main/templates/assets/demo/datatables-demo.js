// Call the dataTables jQuery plugin

$(document).ready(function () {
    let table = $('#dataTable').DataTable({
        "sAjaxSource": "/books",
        "sAjaxDataProp": "",
        "order": [[0, "asc"]],
        "paging": true,
        "columns": [
            {"data": "Isbn"},
            {"data": "Name"},
            {"data": "Author"},
            {"data": "Status"},
        ]
    })
})

