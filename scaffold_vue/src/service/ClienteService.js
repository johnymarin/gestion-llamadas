import axios from 'axios';


export default class ClienteService {

    url = "http://localhost:3000/apiclientes";

    getAll() {
        return axios.get(this.url);
    }

    save(cliente) {
        return axios.post(this.url , cliente)
    }
}