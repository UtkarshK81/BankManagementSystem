export class Address {
    addressId:bigint;
    addressLine1:string;
    addressLine2:string;
    addressLine3:string;
    addressCity:string;
    addressState:string;
    addressCountry:string;
    addressZipcode:number;

    Address(addressId:bigint,addressLine1:string,addressLine2:string,addressLine3:string,addressCity:string,addressState:string,addressCountry:string,addressZipcode:number,)
    {
        this.addressId=addressId;
        this.addressLine1=addressLine1;
        this.addressLine2=addressLine2;
        this.addressLine3=addressLine3;
        this.addressCity=addressCity;
        this.addressState=addressState;
        this.addressCountry=addressCountry;
        this.addressZipcode=addressZipcode;
    }
}
