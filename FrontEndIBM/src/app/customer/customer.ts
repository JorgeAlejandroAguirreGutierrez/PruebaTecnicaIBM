import { Card } from './card';
export class Customer {
    id: number;
    name: string;
    address: string;
    city: string;
    phone: string;
    cards: Card[];

    constructor() {  }
}
