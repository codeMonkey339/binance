import axios from 'axios'

export default class ServiceClient {

    Base_URL = "http://localhost:8080";
    SUBMIT_ADDR_URL = `${this.Base_URL}/addr/post`;

    submitAddr( addr) {
        axios.post(this.SUBMIT_ADDR_URL, addr).then(resp => {
            if (resp.status > 299 || resp.status < 200) {
                console.log(resp);
            } else {
                return;
            }
        })
    }
}