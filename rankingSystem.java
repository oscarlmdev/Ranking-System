class User{
  int rank;
  int progress;
  
 public User(){
    this.rank=-8;
    this.progress=0;
  }
  public int getRank(){
     return rank;
  }
  public int getProgress(){
    return progress;
  }
  public void calculateProgress(int activityRank){
    
      int rankDiff = activityRank-rank;
      if(rank<0 && activityRank>0) rankDiff--;
      if(rank>0 && activityRank<0) rankDiff++;
      if (rankDiff > 0) {
            progress += 10 * rankDiff * rankDiff;
        } else if (rankDiff == 0) {
            progress += 3;
        } else if (rankDiff == -1) {
            progress += 1;
        }
  }
  public void incProgress(int activityRank){
    if(activityRank>8 || activityRank<-8 || activityRank==0){
      throw new IllegalArgumentException("Invalid activity rank");
    }
      calculateProgress(activityRank);
      while(progress>=100){
        progress-=100;
        rank++;
        rank = rank==0 ? 1 : rank;
      }
        if(rank==8) progress = 0;
    
  }
}
