export class Context {


  maxCookTime: number;

  warm: boolean;

  scales: Array<any>;

  constructor(maxCookTime:number, warm:boolean,scales:Array<any>){
    this.maxCookTime=maxCookTime;
    this.warm=warm;
    this.scales=scales;
  }



}
