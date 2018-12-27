import { Bear } from '../models/bear.model'
import { Injectable } from '@angular/core';
import { BearType } from '../models/bear-type.model';
import { Cave } from '../models/cave.model';

@Injectable()
export class BearService {
    public getBears(): Bear[] {
        const bears: Array<Bear> = null;
        const cave1: Cave = new Cave (7, 'Tampa', 6);
        const bearType1: BearType = new BearType (4, 'Grizzly');
        bears.push(new Bear(3, 'Betty', cave1, bearType1, 300, new Date()));
        bears.push(new Bear(4, 'Bob', cave1, bearType1, 400, new Date()));
        bears.push(new Bear(71, 'Gandalf', cave1, bearType1, 300, new Date()));
        return bears;
    }
}