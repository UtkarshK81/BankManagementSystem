import { Address } from './address';

export class Branch {
    branchId:bigint;
    branchName:string;
    address:Address;
    branchIfsc:string;

    Branch(branchId:bigint,branchName:string,address:Address,branchIfsc:string)
    {
        this.branchId=branchId;
        this.branchName=branchName;
        this.address=address;
        this.branchIfsc=branchIfsc;
    }
}
