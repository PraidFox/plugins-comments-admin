export default class Api {



    static customConfig = {
        headers: {
            Authorization: `Basic ${btoa(`${process.env.REACT_APP_LOGIN}:${process.env.REACT_APP_PASSWORD}`)}`
        }
    };

    static baseUrl() {
        if (process.env.NODE_ENV === 'development') {
            return "http://localhost:8080/"
        } else {
            return ""
        }
    }
}