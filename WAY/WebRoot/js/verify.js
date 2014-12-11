var verify = function () {
    "use strict";
    var verify_div = document.getElementById("verify"),
        tags = verify_div.getElementsByTagName("li"),
        forms = verify_div.getElementsByTagName("form"),
        getClass = function (oParent, clsName) {
            var result = [],
                inner_elements = oParent.getElementsByTagName("*");
            for (var i = 0, l = inner_elements.length; i < l; i++) {
                if(inner_elements[i].className.indexOf(clsName)>=0) {
                    result.push(inner_elements[i]);
                }
            }
            return result;
        },
        tables = getClass(verify_div, "info-list"),
        switchTag = function () {
            for (var i = 0, l = tags.length; i < l; i++) {
                if(forms[i]) {
                    forms[i].className = "";
                }
                if(tables[i]) {
                    tables[i].className = "info-list";
                }
                tags[i].className = "";
            }
            tags[this.index].className = "active";
            if(forms[this.index]) {
                forms[this.index].className = "active";
            }
            if(tables[this.index]) {
                tables[this.index].className = "info-list active";
            }
        };
    for (var i = 0, l = tags.length; i < l; i++) {
        tags[i].index = i;
        tags[i].addEventListener("click", switchTag, false);
    }
};
window.addEventListener("load", verify, true);