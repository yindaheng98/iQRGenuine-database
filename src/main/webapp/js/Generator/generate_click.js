function generate_click(info)
{
    var md5_info=md5(info);
    $.post("generate",{md5_info:md5_info},function (data)
    {
        alert(data);
    });
}