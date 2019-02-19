window.top.addEventListener(
    'message',
    request => {
        if (request && request.data && request.data.message === 'get_letznav_global_variables') {
            request.data.message = 'set_letznav_global_variables';
            var keyName = request.data.keyName;
            var keyNames = keyName && keyName.split('.');
            var windowValue;
            for (var key of keyNames) {
                windowValue = windowValue ? windowValue[key] : window.top[key];
            }
            request.data.value = windowValue;
            window.postMessage(request.data, '*');
        }
    },
    true
);
