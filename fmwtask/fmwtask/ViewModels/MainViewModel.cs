using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections.ObjectModel;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;

namespace fmwtask.Views
{
    class MainViewModel:BaseViewModel
    {
        #region Props
        SQLiteRepos<Gun> sr; //Репозиторий сущностей
        SQLiteRepos<Type> tr; //Репозиторий типов сущности
        List<Type> TypeColl;

        private ObservableCollection<Gun> lwContent; //Контент ListView
        public ObservableCollection<Gun> LwContent
        {
            get { return lwContent; }
            set
            {
                lwContent = value;
                OnPropertyChanged("LwContent");
            }
        }

        private Gun selectedItem; // Выбраный в ListView элемент
        public Gun SelectedItem
        {
            get { return selectedItem; }
            set
            {
                selectedItem = value;
                OnPropertyChanged("SelectedItem");

                sr.ModifyState(SelectedItem);
                Type = TypeColl[(int)SelectedItem.Type-1];
                
            }
        }

        private Type type;
        public Type Type
        {
            get { return type; }
            set
            {
                type = value;
                OnPropertyChanged("Type");
                tr.ModifyState(Type);
            }
        }
        #endregion
        #region Commands
        public IDelegateCommand SaveChanges { get; set; } //Комманда для сохранения изменений
        void ExecuteSaveChanges(object param)
        {
            this.sr.Save();
            this.tr.Save();
        } //Параметры выполнения комманды SaveChanges

        public IDelegateCommand RemoveChanges { get; set; } //Комманда для отката изменений
        void ExecuteRemoveChanges(object param)
        {
            this.sr.Retrieve();
            this.tr.Retrieve();
            SelectedItem = LwContent[0];
            
        } //Параметры выполнения комманды RemoveChanges
        #endregion 
        public MainViewModel()
        {
            sr = new SQLiteRepos<Gun>();
            tr = new SQLiteRepos<Type>();

            LwContent = new ObservableCollection<Gun>(sr.ReturnList());
            TypeColl = tr.ReturnList();
            this.SaveChanges = new DelegateCommand(ExecuteSaveChanges);
            this.RemoveChanges = new DelegateCommand(ExecuteRemoveChanges);
            
        }
    }
}
