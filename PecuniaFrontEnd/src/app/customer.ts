import { Address } from './address';

export class Customer {
    custId:bigint;
    custName:string;
    custAadhar:string;
    custPan:string;
    custContact:string;
    custDob:string;
    gender:string;
    custEmail:string;
    address:Address;

    Customer(custId:bigint,custName:string,custAadhar:string,custPan:string,custContact:string,custDob:string,gender:string,custEmail:string,address:Address,)
    {
        this.custId=custId;
        this.custName=custName;
        this.custAadhar=custAadhar;
        this.custPan=custPan;
        this.custContact=custContact;
        this.custDob=custDob;
        this.gender=gender;
        this.custEmail=custEmail;
        this.address=address;
    }
}
