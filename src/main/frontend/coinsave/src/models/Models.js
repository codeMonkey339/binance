export class Address {
    constructor(userId, addr, proof, trans, imgPath,
     scamType,  coinType) {
        this.userId = userId;
        this.addr = addr;
        this.trans = trans;
        this.imgPath = imgPath;
        this.scamType = scamType;
        this.coinType = coinType;
    }
}