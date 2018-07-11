export class Context {


  maxCookTime: number;

  warm: boolean;
  type:string;

  scales: Array<any>;

  constructor(maxCookTime:number, warm:boolean, type:string,scales:Array<any>){
    this.maxCookTime=maxCookTime;
    this.warm=warm;
    this.type=type;
    this.scales=scales;
  }



}
